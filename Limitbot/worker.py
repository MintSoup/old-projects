import asyncio
import discord
import json
import datetime
import re
def loadData():
    global rawData
    try:
        with open("data.json","r") as f:
            rawData = json.load(f)
            print("data file found. here's the data in it")
            for key, value in rawData.items():
                print(key,": ",value)
    except:
        print("no data file found, using hardcoded values :(")
        initDataRaw()
def saveData():
    with open("data.json","w") as f:
        print("saving...")
        json.dump(rawData,f,indent=4)

def initDataRaw():
    global rawData
    rawData["server"] = "412925321537388545"
    rawData["giveaways"] = "413281004665700352"
    rawData["suggestions"] = "413281678929428481"
    rawData["member"] = "412926132535427073"
    rawData["muted"] = "412926509435584513"
    rawData["staff"] = "412925973131034624"
    rawData["apps"] = "413283206033571841"
    rawData["member+"] = "412928619564761098"

    rawData["yellow"] = "401344150777102348"
    rawData["orange"] = "401343846153191425"
    rawData["green"] = "401343947839897612"
    rawData["blue"] = "401343809985708032"
    rawData["logs"] = "364451404120719360"






def initData():
    global data
    g = {}
    g["server"] = client.get_server(rawData["server"])
    g["giveaways"] = client.get_channel(rawData["giveaways"])
    g["suggestions"] = client.get_channel(rawData["suggestions"])
    g["roles"] = g["server"].role_hierarchy
    g["member"] = discord.utils.find(lambda role: role.id == rawData["member"],g["roles"])
    g["muted"] = discord.utils.find(lambda role: role.id == rawData["muted"],g["roles"])
    g["staff"] = discord.utils.find(lambda role: role.id == rawData["staff"],g["roles"])
    g["member+"] = discord.utils.find(lambda role: role.id == rawData["member+"],g["roles"])

    g["green"] = discord.utils.find(lambda role: role.id == rawData["green"],g["roles"])
    g["orange"] = discord.utils.find(lambda role: role.id == rawData["orange"],g["roles"])
    g["blue"] = discord.utils.find(lambda role: role.id == rawData["blue"],g["roles"])
    g["yellow"] = discord.utils.find(lambda role: role.id == rawData["yellow"],g["roles"])

    g["logs"] = client.get_channel(rawData["logs"])
    g["apps"] = client.get_channel(rawData["apps"])
    data = g





member = """
>suggest: Suggest us something to add.
>info: Info about LimitCommunity
>apply: Use this to apply for staff. I (Limitbot) will DM you everything you need.
>color: Change your chat color
"""
staff = """
>clear <amount>: Clear amount messages in this channel.
>mute <member>: Mute someone.
>unmute <member>: Unmute someone.
>kick <member>: Kick someone.
>ban <member>: Ban someone.
>unban <username#id>: Unban somone.
>vote: Create a poll.
"""
noperm = "** You are not allowed to use this command.**"
client = discord.Client()

rawData = {}
data = {}
@client.event
async def on_ready():
    global cross
    global tick
    loadData()
    initData()
    await client.change_presence(game=discord.Game(name=">help"))

tick = "✅"
cross = "❎"

@client.event
async def on_message(message):
    global data
    global staff
    global member

    try:
        if message.author == message.server.me:
            return
    except:
        return

    if (datetime.datetime.now() - message.author.joined_at).days > 31 and not data["member+"] in message.author.roles:
        await client.send_message(message.channel,"Congratulations, {}! You have been a member of this server for a long time and now you are a Member+! You can now use `>color` and apply for staff!".format(message.author.mention))
        await client.add_roles(message.author,data["member+"])

    if message.content.startswith(">"):
        cmd = message.content[1:]
        chnl = message.channel
        auth = message.author
        assert isinstance(chnl,discord.Channel)
        assert isinstance(auth,discord.Member)
        if cmd.startswith("suggest"):

            suggestion = cmd[8:]
            embed = discord.Embed(color=0x820000)
            embed.set_thumbnail(url=auth.avatar_url)
            embed.add_field(name="Suggestion from {}:".format(auth.name) ,value=suggestion)
            msg = await client.send_message(data["suggestions"], embed=embed)
            await client.add_reaction(msg,tick)
            await client.add_reaction(msg,cross)
            await log("{} suggested: {}".format(name(auth),suggestion))
        elif cmd == "roleid":
            xd = ""
            for role in data["roles"]:
                xd += "{}: {}".format(role.name,role.id)+"\n"
            await client.send_message(chnl,"```{}```".format(xd))
        elif cmd.startswith("clear"):

            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            g = int(cmd[6:])
            logs = []
            async for xd in client.logs_from(chnl, limit=g):
                if not xd.pinned:
                    logs.append(xd)
            await client.delete_messages(logs)
            await log("{} cleared {} messages from {}".format(name(auth),g,chnl.mention))
        elif cmd == "help":

            embed = discord.Embed(color=0x820000)
            embed.set_thumbnail(url=data["server"].icon_url)
            embed.add_field(name="Member commands",value=member)
            if isStaff(auth):
                embed.add_field(name="Staff commands",value=staff)
            await client.send_message(chnl,embed=embed)
        elif cmd.startswith("mute"):

            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            user = cmd[5:]
            member = findMember(user)
            if member is None:
                await client.send_message(chnl,"Cannot find that member")
            else:
                await client.add_roles(member,data["muted"])
                await client.send_message(chnl,"Muted " + member.mention)
                await log("{} muted {}".format(name(auth),name(member)))



        elif cmd.startswith("unmute"):

            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            user = cmd[7:]
            member = findMember(user)
            if member is None:
                await client.send_message(chnl,"Cannot find that member")
            else:
                await client.remove_roles(member,data["muted"])
                await client.send_message(chnl,"Unmuted " + member.mention)
                await log("{} unmuted {}".format(name(auth),name(member)))
        elif cmd.startswith("ban"):

            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            user = cmd[4:]
            member = findMember(user)

            if member is None:
                await client.send_message(chnl,"Cannot find that member")
            else:
                assert isinstance(member,discord.Member)
                await client.send_message(chnl,"Reason: ")
                x = await client.wait_for_message(timeout=30,channel=chnl,author=auth)
                if x is None:
                    await client.send_message(chnl,"Aborting ban")
                else:

                    embed = discord.Embed(color=0x820000)
                    embed.title = "{}#{} got banned".format(member.name,member.discriminator)
                    embed.set_thumbnail(url=member.avatar_url)
                    embed.add_field(name="Moderator: ",value=auth.mention)
                    embed.add_field(name="Reason:",value = x.content)
                    await client.ban(member)
                    await client.send_message(chnl,embed=embed)
                    await log("{} banned {}. Reason: {}".format(name(auth),name(member),x.content))
        elif cmd.startswith("kick"):

            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            user = cmd[5:]
            member = findMember(user)
            if member is None:
                await client.send_message(chnl,"Cannot find that member")
            else:
                assert isinstance(member,discord.Member)
                await client.send_message(chnl,"Reason: ")
                x = await client.wait_for_message(timeout=30,channel=chnl,author=auth)
                if x is None:
                    await client.send_message(chnl,"Aborting kick")
                else:

                    embed = discord.Embed(color=0x820000)
                    embed.title = "{}#{} got kicked".format(member.name,member.discriminator)
                    embed.set_thumbnail(url=member.avatar_url)
                    embed.add_field(name="Moderator: ",value=auth.mention)
                    embed.add_field(name="Reason:",value = x.content)
                    await client.kick(member)
                    await client.send_message(chnl,embed=embed)
                    await log("{} kicked {}. Reason: {}".format(name(auth),name(member),x))
        elif cmd.startswith("unban"):

            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            user = cmd[6:]
            member = discord.utils.find(lambda x: x.name+"#"+x.discriminator == user,await client.get_bans(data["server"]))
            if member is None:
                await client.send_message(chnl,"Cannot find that member")
            else:
                assert isinstance(member,discord.User)
                embed = discord.Embed(color=0x820000)
                embed.title = "{}#{} got unbanned".format(member.name,member.discriminator)
                embed.set_thumbnail(url=member.avatar_url)
                embed.add_field(name="Moderator: ",value=auth.mention)
                await client.unban(user=member,server=data["server"])
                await client.send_message(chnl,embed=embed)
                await log("{} unbanned {}".format(name(auth),user))
        elif cmd == "info":

            embed = discord.Embed(color=0x820000)
            embed.set_thumbnail(url=data["server"].icon_url)
            embed.add_field(name="Members",value=len([x for x in data["server"].members if not x.bot]))
            embed.add_field(name="Bots",value=len([x for x in data["server"].members if x.bot]))
            embed.add_field(name="Online",value=len([x for x in data["server"].members if x.status == discord.Status.online and not x.bot]))
            embed.add_field(name="Owner", value="MintSoup")
            await client.send_message(chnl,embed=embed)
        elif cmd == "save":

            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            saveData()
            await client.send_message(chnl,"Done saving.")
        elif cmd == "reload":

            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            loadData()
            initData()
            await client.send_message(chnl,"Reloaded data files")
        elif cmd == "die":
            if not isStaff(auth):
                await client.send_message(chnl,noperm)
                return
            saveData()
            await client.send_message(chnl,"Shutting down...")
            client.logout()
            exit(0)
        elif cmd == "vote":
            if data["dev"] in auth.roles or auth == data["server"].owner:
                dltmsgs = []
                dltmsgs.append(message)
                dltmsgs.append(await client.send_message(chnl,"Enter vote text"))
                t = await client.wait_for_message(channel=chnl,author=auth)
                dltmsgs.append(t)
                embed = discord.Embed(color=0x820000)
                embed.set_thumbnail(url=data["server"].icon_url)
                embed.add_field(name="Poll",value=t.content)
                msg = await client.send_message(chnl,embed=embed)
                await client.add_reaction(msg,tick)
                await client.add_reaction(msg,cross)
                await client.delete_messages(dltmsgs)
                await log("{} created a vote on {}. Vote question:\n{}".format(name(auth),chnl.mention,t.content))
            else:
                await client.send_message(chnl,noperm)
                return
        elif cmd == "apply":
            await client.delete_message(message)
            if data["member+"] in auth.roles:
                questions = [
                "Why do you want to become staff?",
                "How old are you? (Lying here will get you nowhere)",
                "How you ever been staff before, anywhere? If so, where?",
                "Let's say someone is breaking the rules (for example spamming). What would you do?",
                "How often are you online? (Hours and days)"
                ]
                answers = []
                await client.send_message(auth,"Greetings! You have applied to become staff. Please answer the following questions.")

                ch = [x for x in client.private_channels if x.is_private and auth in x.recipients][0]
                for q in questions:
                    await client.send_message(ch,q)
                    g = await client.wait_for_message(channel=ch,author=auth)
                    answers.append(g.content)

                await client.send_message(auth,"Thank you for applying. Staff will review your application.")
                embed = discord.Embed(color=0x820000)
                embed.set_thumbnail(url=data["server"].icon_url)
                embed.title = "{}#{} applied for staff.".format(auth.name,auth.discriminator)
                for g in range(0,len(questions)):
                    embed.add_field(name=questions[g],value=answers[g])

                application = await client.send_message(data["apps"],data["staff"].mention,embed=embed)
                await client.add_reaction(application,tick)
                await client.add_reaction(application,cross)

                await log("{} applied for staff".format(name(auth)))
            else:
                await client.send_message(auth,"Sorry, to apply for staff you need to have the automatically given member+ role.")
        elif cmd.startswith("color"):
            await client.remove_roles(auth,data["green"],data["blue"],data["orange"],data["yellow"])
            if not data["member+"] in auth.roles:
                await client.send_message(chnl,"You need the member+ role to use this command.")
                return
            if len(cmd) == 5:
                await client.send_message(chnl,"Reset your colors.")
                return
            else:
                color = cmd[6:]
                colors = ["green","blue","orange","yellow"]
                if color in colors:
                    await client.send_message(chnl,"Set your color to {}.".format(color))
                    await client.add_roles(auth,data[color])
                    await log("{} chaned their color to {}".format(name(auth),color))
                else:
                    colorstr = ""
                    for g in colors:
                        colorstr+=g+", "
                    colorstr = colorstr[:-2]
                    await client.send_message(chnl,"The available colors are {}.".format(colorstr))

async def log(logs):
    await client.send_message(data["logs"],logs)

def name(user):
    return "{}#{}".format(user.name,user.discriminator)
def findMember(mention):
    mentionID = "".join([x for x in mention if x in "1234567890"])
    pattern = re.compile(r"\<@(\!)?"+mentionID+"*\>")
    for member in data["server"].members:
        if pattern.search(member.mention) is not None:
            return member

def isStaff(g):
    assert isinstance(g,discord.Member)
    return data["staff"] in g.roles


async def on_member_join(member):
    await client.add_roles(member,data["member"])



client.run("NDE3NjUyNTI5OTc1Nzg3NTIw.DXWn4Q.lwMQKS1e-1ruGR2A4et28yb9iDc")
