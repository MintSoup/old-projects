
#include <fstream>
#include <iostream>
#include <conio.h>
#include <stack>
#include <stdlib.h>
#include <vector>
using namespace std;

void execute(char c);

int pos;

unsigned char cells[30000];
unsigned char* pntr = cells;
int ignore;
bool wordmode;
stack<int> label;

int main(int argc, char* argv[])
{
    if(argc != 2 && argc != 3)
    {
        cout
        <<"Usage: BFInterpreter.exe [-i] <filename>"<<endl
        <<"-i: enable idiot mode"<<endl
        <<"idiot mode: Basically replaces"<<endl
        <<"+ with 'add'"<<endl
        <<"- with 'sub'"<<endl
        <<"> with 'right'"<<endl
        <<"< with 'left'"<<endl
        <<"[ with 'loopb'"<<endl
        <<"] with 'loope'"<<endl
        <<". with 'out'"<<endl
        <<", with 'in'"<<endl
        <<"/ with 'say'"<<endl<<endl
        <<"Example: 'add add add add add loopb right add add add add add add add add add add add add add left sub loope right out' Prints 'A'"

        <<endl;

        return 1;
    }
    if(argc > 2)
    {
        string arg = argv[2];
        if("-i"==arg)
        {
            wordmode = true;
        }
    }


    if(!wordmode)
    {
        ifstream reader(argv[1]);
        string stuff((istreambuf_iterator<char>(reader)),
                     istreambuf_iterator<char>());
        reader.close();
        char program[stuff.length()];
        stuff.copy(program,stuff.length());

        while(pos<sizeof(program))
        {
            execute(program[pos]);
            pos++;
        }
    }
    else
    {

        vector<string> cmds;
        ifstream reader(argv[1]);
        string buf;
        while(reader>>buf)
        {
            cmds.push_back(buf);
        }
        reader.close();
        while(pos<cmds.size())
        {
            string c = cmds.at(pos);
            if(c=="add")
            {
                execute('+');
            }
            else if (c == "sub")
            {
                execute('-');
            }
            else if (c == "right")
            {
                execute('>');
            }
            else if (c == "left")
            {
                execute('<');
            }
            else if (c == "out")
            {
                execute('.');
            }
            else if (c == "in")
            {
                execute(',');
            }
            else if (c == "loopb")
            {
                execute('[');
            }
            else if (c == "loope")
            {
                execute(']');
            }
            else if(c=="say")
            {
                execute('/');
            }
            else
            {
                cout<<"INVALID COMMAND: "<<c<<endl;
                exit(-1);
            }
            pos++;
        }

    }
    if(!label.empty())
    {
        system("cls");
        cout<<"SYNTAX ERROR: UNMATCHED BRACKETS"<<endl;
        return -2;
    }
    return 0;

}

void execute(char c)
{

    switch(c)
    {
    case '+':
    {
        if(ignore<1)
        {
            (*pntr)++;
        }
        break;
    }
    case '-':
    {
        if(ignore<1)
        {
            (*pntr)--;
            //if(cells[pntr]<0)cells[pntr] = 255;
        }
        break;
    }
    case '>':
    {
        if(ignore<1)
        {
            pntr++;
        }
        break;
    }
    case '<':
    {
        if(ignore<1)
        {
            pntr--;
        }
        break;
    }
    case '.':
    {
        if(ignore<1)
        {
            cout<<(char)(*pntr);
        }
        break;
    }
    case '/':
    {
        if(ignore<1)
        {
            cout<<(int)(*pntr)<<endl;
        }
        break;
    }
    case ',':
    {
        if(ignore<1)
        {
            (*pntr) = getchar();
        }
        break;
    }
    case '[':
    {
        if((*pntr)>0)
        {
            label.push(pos-1);
        }
        else
        {
            ignore++;
        }
        break;
    }
    case ']':
    {
        if(ignore>0)
        {
            ignore--;
        }
        else
        {
            if(!label.empty())
            {
                pos = label.top();
                label.pop();
            }
            else
            {
                cout<<"SYNTAX ERROR: UNMATCHED BRACKETS"<<endl;
                exit(-2);
            }

        }
        break;
    }
    default:
    {

        break;
    }
    }
}

