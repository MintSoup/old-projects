EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L power:GND #PWR0101
U 1 1 5E9085B4
P 2150 5500
F 0 "#PWR0101" H 2150 5250 50  0001 C CNN
F 1 "GND" H 2155 5327 50  0000 C CNN
F 2 "" H 2150 5500 50  0001 C CNN
F 3 "" H 2150 5500 50  0001 C CNN
	1    2150 5500
	1    0    0    -1  
$EndComp
Text GLabel 1650 3950 0    50   Input ~ 0
NRST
$Comp
L Device:R R2
U 1 1 5E90B2DB
P 1150 1050
F 0 "R2" H 1080 1004 50  0000 R CNN
F 1 "10k" H 1080 1095 50  0000 R CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 1080 1050 50  0001 C CNN
F 3 "~" H 1150 1050 50  0001 C CNN
	1    1150 1050
	-1   0    0    1   
$EndComp
Text GLabel 1050 1200 0    50   Input ~ 0
NRST
Wire Wire Line
	1050 1200 1150 1200
$Comp
L power:+3V3 #PWR0102
U 1 1 5E9143F1
P 1150 900
F 0 "#PWR0102" H 1150 750 50  0001 C CNN
F 1 "+3V3" H 1165 1073 50  0000 C CNN
F 2 "" H 1150 900 50  0001 C CNN
F 3 "" H 1150 900 50  0001 C CNN
	1    1150 900 
	1    0    0    -1  
$EndComp
Text GLabel 950  2350 0    50   Input ~ 0
BOOT0
Wire Wire Line
	950  2350 1000 2350
Wire Wire Line
	1000 2350 1000 2400
$Comp
L power:GND #PWR0104
U 1 1 5E91BE3A
P 1000 2700
F 0 "#PWR0104" H 1000 2450 50  0001 C CNN
F 1 "GND" H 1005 2527 50  0000 C CNN
F 2 "" H 1000 2700 50  0001 C CNN
F 3 "" H 1000 2700 50  0001 C CNN
	1    1000 2700
	1    0    0    -1  
$EndComp
Text GLabel 1650 4750 0    50   Input ~ 0
PF0
Text GLabel 1650 4850 0    50   Input ~ 0
PF1
Text GLabel 4550 2650 0    50   Input ~ 0
PF0
Text GLabel 4550 2950 0    50   Input ~ 0
PF1
Wire Wire Line
	4550 2650 4900 2650
$Comp
L Device:Crystal Y1
U 1 1 5E92B2C8
P 4900 2800
F 0 "Y1" V 4854 2931 50  0000 L CNN
F 1 "Crystal" V 4945 2931 50  0000 L CNN
F 2 "Crystal:Crystal_HC49-4H_Vertical" H 4900 2800 50  0001 C CNN
F 3 "~" H 4900 2800 50  0001 C CNN
	1    4900 2800
	0    1    1    0   
$EndComp
$Comp
L Device:C C2
U 1 1 5E92DBE7
P 4900 3100
F 0 "C2" H 5015 3146 50  0000 L CNN
F 1 "15p" H 5015 3055 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 4938 2950 50  0001 C CNN
F 3 "~" H 4900 3100 50  0001 C CNN
	1    4900 3100
	1    0    0    -1  
$EndComp
Wire Wire Line
	4900 2950 4550 2950
Connection ~ 4900 2950
$Comp
L Device:C C1
U 1 1 5E9304A4
P 4900 2500
F 0 "C1" H 5015 2546 50  0000 L CNN
F 1 "15p" H 5015 2455 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 4938 2350 50  0001 C CNN
F 3 "~" H 4900 2500 50  0001 C CNN
	1    4900 2500
	1    0    0    -1  
$EndComp
Connection ~ 4900 2650
$Comp
L power:GND #PWR0108
U 1 1 5E930CC8
P 4900 3250
F 0 "#PWR0108" H 4900 3000 50  0001 C CNN
F 1 "GND" H 4905 3077 50  0000 C CNN
F 2 "" H 4900 3250 50  0001 C CNN
F 3 "" H 4900 3250 50  0001 C CNN
	1    4900 3250
	1    0    0    -1  
$EndComp
$Comp
L power:GND #PWR0109
U 1 1 5E9310E7
P 4900 2350
F 0 "#PWR0109" H 4900 2100 50  0001 C CNN
F 1 "GND" H 4905 2177 50  0000 C CNN
F 2 "" H 4900 2350 50  0001 C CNN
F 3 "" H 4900 2350 50  0001 C CNN
	1    4900 2350
	1    0    0    1   
$EndComp
$Comp
L MCU_ST_STM32F0:STM32F030F4Px U1
U 1 1 5E93D04F
P 2150 4450
F 0 "U1" H 2150 3561 50  0000 C CNN
F 1 "STM32F030F4Px" H 2150 3470 50  0000 C CNN
F 2 "Package_SO:TSSOP-20_4.4x6.5mm_P0.65mm" H 1750 3750 50  0001 R CNN
F 3 "http://www.st.com/st-web-ui/static/active/en/resource/technical/document/datasheet/DM00088500.pdf" H 2150 4450 50  0001 C CNN
	1    2150 4450
	1    0    0    -1  
$EndComp
Wire Wire Line
	2150 5500 2150 5250
$Comp
L power:+3V3 #PWR0110
U 1 1 5E9072CA
P 2200 3750
F 0 "#PWR0110" H 2200 3600 50  0001 C CNN
F 1 "+3V3" H 2215 3923 50  0000 C CNN
F 2 "" H 2200 3750 50  0001 C CNN
F 3 "" H 2200 3750 50  0001 C CNN
	1    2200 3750
	1    0    0    -1  
$EndComp
Wire Wire Line
	2150 3750 2200 3750
Connection ~ 2200 3750
Wire Wire Line
	2200 3750 2250 3750
Text GLabel 1650 5050 0    50   Input ~ 0
PB1
Text GLabel 2150 1150 0    50   Input ~ 0
PA1
$Comp
L Device:LED D1
U 1 1 5E9634E3
P 2300 1150
F 0 "D1" H 2293 895 50  0000 C CNN
F 1 "LED" H 2293 986 50  0000 C CNN
F 2 "LED_SMD:LED_0603_1608Metric" H 2300 1150 50  0001 C CNN
F 3 "~" H 2300 1150 50  0001 C CNN
	1    2300 1150
	-1   0    0    1   
$EndComp
$Comp
L Device:R R1
U 1 1 5E91AFE7
P 1000 2550
F 0 "R1" H 930 2504 50  0000 R CNN
F 1 "10k" H 930 2595 50  0000 R CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 930 2550 50  0001 C CNN
F 3 "~" H 1000 2550 50  0001 C CNN
	1    1000 2550
	-1   0    0    1   
$EndComp
$Comp
L Device:R R3
U 1 1 5E96448F
P 2600 1400
F 0 "R3" H 2530 1354 50  0000 R CNN
F 1 "1k" H 2530 1445 50  0000 R CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 2530 1400 50  0001 C CNN
F 3 "~" H 2600 1400 50  0001 C CNN
	1    2600 1400
	-1   0    0    1   
$EndComp
$Comp
L power:GND #PWR0111
U 1 1 5E964E76
P 2600 1550
F 0 "#PWR0111" H 2600 1300 50  0001 C CNN
F 1 "GND" H 2605 1377 50  0000 C CNN
F 2 "" H 2600 1550 50  0001 C CNN
F 3 "" H 2600 1550 50  0001 C CNN
	1    2600 1550
	1    0    0    -1  
$EndComp
Wire Wire Line
	3300 3000 3300 3050
Wire Wire Line
	3300 3000 3700 3000
Connection ~ 3300 3000
Wire Wire Line
	2900 3000 3300 3000
Connection ~ 3700 2700
$Comp
L Device:C C4
U 1 1 5E953461
P 3700 2850
F 0 "C4" H 3815 2896 50  0000 L CNN
F 1 "100n" H 3815 2805 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 3738 2700 50  0001 C CNN
F 3 "~" H 3700 2850 50  0001 C CNN
	1    3700 2850
	1    0    0    -1  
$EndComp
Connection ~ 2900 2700
$Comp
L Device:C C3
U 1 1 5E9525F2
P 2900 2850
F 0 "C3" H 3015 2896 50  0000 L CNN
F 1 "100n" H 3015 2805 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 2938 2700 50  0001 C CNN
F 3 "~" H 2900 2850 50  0001 C CNN
	1    2900 2850
	1    0    0    -1  
$EndComp
Wire Wire Line
	3700 2700 3700 2600
Wire Wire Line
	3600 2700 3700 2700
Wire Wire Line
	2900 2700 3000 2700
Wire Wire Line
	2900 2600 2900 2700
$Comp
L power:GND #PWR0112
U 1 1 5E94F79A
P 3300 3050
F 0 "#PWR0112" H 3300 2800 50  0001 C CNN
F 1 "GND" H 3305 2877 50  0000 C CNN
F 2 "" H 3300 3050 50  0001 C CNN
F 3 "" H 3300 3050 50  0001 C CNN
	1    3300 3050
	1    0    0    -1  
$EndComp
$Comp
L power:+3V3 #PWR0113
U 1 1 5E94EB9D
P 3700 2600
F 0 "#PWR0113" H 3700 2450 50  0001 C CNN
F 1 "+3V3" H 3715 2773 50  0000 C CNN
F 2 "" H 3700 2600 50  0001 C CNN
F 3 "" H 3700 2600 50  0001 C CNN
	1    3700 2600
	1    0    0    -1  
$EndComp
$Comp
L power:VCC #PWR0114
U 1 1 5E94E634
P 2900 2600
F 0 "#PWR0114" H 2900 2450 50  0001 C CNN
F 1 "VCC" H 2917 2773 50  0000 C CNN
F 2 "" H 2900 2600 50  0001 C CNN
F 3 "" H 2900 2600 50  0001 C CNN
	1    2900 2600
	1    0    0    -1  
$EndComp
$Comp
L Regulator_Linear:AMS1117-3.3 U2
U 1 1 5E94B251
P 3300 2700
F 0 "U2" H 3300 2942 50  0000 C CNN
F 1 "AMS1117-3.3" H 3300 2851 50  0000 C CNN
F 2 "Package_TO_SOT_SMD:SOT-223-3_TabPin2" H 3300 2900 50  0001 C CNN
F 3 "http://www.advanced-monolithic.com/pdf/ds1117.pdf" H 3400 2450 50  0001 C CNN
	1    3300 2700
	1    0    0    -1  
$EndComp
Text GLabel 2650 3950 2    50   Input ~ 0
PA0
Text GLabel 2650 4050 2    50   Input ~ 0
PA1
Text GLabel 2650 4150 2    50   Input ~ 0
PA2
Text GLabel 2650 4250 2    50   Input ~ 0
PA3
Text GLabel 2650 4350 2    50   Input ~ 0
PA4
Text GLabel 2650 4450 2    50   Input ~ 0
PA5
Text GLabel 2650 4550 2    50   Input ~ 0
PA6
Text GLabel 2650 4650 2    50   Input ~ 0
PA7
Text GLabel 2650 4750 2    50   Input ~ 0
PA9
Text GLabel 2650 4850 2    50   Input ~ 0
PA10
Text GLabel 2650 5050 2    50   Input ~ 0
PA14
Text GLabel 4550 4700 2    50   Input ~ 0
PA2
Text GLabel 4550 4600 2    50   Input ~ 0
PA1
Text GLabel 1650 4150 0    50   Input ~ 0
BOOT0
Text GLabel 4550 4300 2    50   Input ~ 0
PF0
Text GLabel 4550 4400 2    50   Input ~ 0
PF1
$Comp
L Connector:Conn_01x04_Male J1
U 1 1 5E9B92A8
P 1800 2350
F 0 "J1" V 1954 2062 50  0000 R CNN
F 1 "Conn_01x04_Male" V 1863 2062 50  0000 R CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x04_P2.54mm_Horizontal" H 1800 2350 50  0001 C CNN
F 3 "~" H 1800 2350 50  0001 C CNN
	1    1800 2350
	1    0    0    -1  
$EndComp
$Comp
L power:+3V3 #PWR0115
U 1 1 5E9BEC25
P 2000 2550
F 0 "#PWR0115" H 2000 2400 50  0001 C CNN
F 1 "+3V3" H 2015 2723 50  0000 C CNN
F 2 "" H 2000 2550 50  0001 C CNN
F 3 "" H 2000 2550 50  0001 C CNN
	1    2000 2550
	-1   0    0    1   
$EndComp
$Comp
L power:GND #PWR0116
U 1 1 5E9C0594
P 2000 2250
F 0 "#PWR0116" H 2000 2000 50  0001 C CNN
F 1 "GND" H 2005 2077 50  0000 C CNN
F 2 "" H 2000 2250 50  0001 C CNN
F 3 "" H 2000 2250 50  0001 C CNN
	1    2000 2250
	-1   0    0    1   
$EndComp
Text GLabel 2000 2350 2    50   Input ~ 0
PA14
Text GLabel 2650 4950 2    50   Input ~ 0
PA13
Text GLabel 2000 2450 2    50   Input ~ 0
PA13
$Comp
L power:+3V3 #PWR0118
U 1 1 5E9CE14B
P 3100 1150
F 0 "#PWR0118" H 3100 1000 50  0001 C CNN
F 1 "+3V3" H 3115 1323 50  0000 C CNN
F 2 "" H 3100 1150 50  0001 C CNN
F 3 "" H 3100 1150 50  0001 C CNN
	1    3100 1150
	-1   0    0    -1  
$EndComp
$Comp
L Device:LED D2
U 1 1 5E9CB7F5
P 2900 1150
F 0 "D2" H 2893 895 50  0000 C CNN
F 1 "LED" H 2893 986 50  0000 C CNN
F 2 "LED_SMD:LED_0603_1608Metric" H 2900 1150 50  0001 C CNN
F 3 "~" H 2900 1150 50  0001 C CNN
	1    2900 1150
	1    0    0    1   
$EndComp
Wire Wire Line
	3100 1150 3050 1150
$Comp
L power:+3V3 #PWR0106
U 1 1 5E9235AD
P 3750 1100
F 0 "#PWR0106" H 3750 950 50  0001 C CNN
F 1 "+3V3" H 3765 1273 50  0000 C CNN
F 2 "" H 3750 1100 50  0001 C CNN
F 3 "" H 3750 1100 50  0001 C CNN
	1    3750 1100
	1    0    0    -1  
$EndComp
$Comp
L power:GND #PWR0107
U 1 1 5E92378C
P 3750 1600
F 0 "#PWR0107" H 3750 1350 50  0001 C CNN
F 1 "GND" H 3755 1427 50  0000 C CNN
F 2 "" H 3750 1600 50  0001 C CNN
F 3 "" H 3750 1600 50  0001 C CNN
	1    3750 1600
	1    0    0    -1  
$EndComp
$Comp
L Device:C C6
U 1 1 5E92616C
P 3750 1350
F 0 "C6" H 3865 1396 50  0000 L CNN
F 1 "100n" H 3865 1305 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 3788 1200 50  0001 C CNN
F 3 "~" H 3750 1350 50  0001 C CNN
	1    3750 1350
	1    0    0    -1  
$EndComp
Wire Wire Line
	3750 1100 3750 1200
Wire Wire Line
	3750 1500 3750 1600
Connection ~ 1150 1200
Wire Wire Line
	2450 1150 2600 1150
Wire Wire Line
	2600 1150 2600 1250
Connection ~ 2600 1150
Wire Wire Line
	2600 1150 2750 1150
Text GLabel 4550 4000 2    50   Input ~ 0
VCC
Text GLabel 4550 4500 2    50   Input ~ 0
PA0
Text GLabel 4550 4900 2    50   Input ~ 0
PA4
Text GLabel 4550 4800 2    50   Input ~ 0
PA3
Text GLabel 5350 4100 0    50   Input ~ 0
PA14
Text GLabel 5350 4200 0    50   Input ~ 0
PA13
Text GLabel 5350 4300 0    50   Input ~ 0
PA10
Text GLabel 5350 4400 0    50   Input ~ 0
PA9
Text GLabel 5350 4900 0    50   Input ~ 0
GND
Text GLabel 4550 4100 2    50   Input ~ 0
+3V3
Text GLabel 5350 4600 0    50   Input ~ 0
PA7
Text GLabel 5350 4700 0    50   Input ~ 0
PA6
Text GLabel 5350 4800 0    50   Input ~ 0
PA5
Text GLabel 5350 4500 0    50   Input ~ 0
PB1
Text GLabel 5350 4000 0    50   Input ~ 0
NRST
Text GLabel 4550 4200 2    50   Input ~ 0
GND
$Comp
L Connector:Conn_01x10_Male J2
U 1 1 5E983158
P 4350 4400
F 0 "J2" H 4458 4981 50  0000 C CNN
F 1 "Conn_01x10_Male" H 4458 4890 50  0000 C CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x10_P2.54mm_Vertical" H 4350 4400 50  0001 C CNN
F 3 "~" H 4350 4400 50  0001 C CNN
	1    4350 4400
	1    0    0    -1  
$EndComp
$Comp
L Connector:Conn_01x10_Male J3
U 1 1 5E983CDA
P 5550 4400
F 0 "J3" H 5522 4282 50  0000 R CNN
F 1 "Conn_01x10_Male" H 5522 4373 50  0000 R CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x10_P2.54mm_Vertical" H 5550 4400 50  0001 C CNN
F 3 "~" H 5550 4400 50  0001 C CNN
	1    5550 4400
	-1   0    0    -1  
$EndComp
$Comp
L Device:C C5
U 1 1 5EA2F903
P 1600 1350
F 0 "C5" H 1715 1396 50  0000 L CNN
F 1 "100n" H 1715 1305 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 1638 1200 50  0001 C CNN
F 3 "~" H 1600 1350 50  0001 C CNN
	1    1600 1350
	1    0    0    -1  
$EndComp
$Comp
L power:GND #PWR0103
U 1 1 5E91575E
P 1400 1600
F 0 "#PWR0103" H 1400 1350 50  0001 C CNN
F 1 "GND" H 1405 1427 50  0000 C CNN
F 2 "" H 1400 1600 50  0001 C CNN
F 3 "" H 1400 1600 50  0001 C CNN
	1    1400 1600
	1    0    0    -1  
$EndComp
$Comp
L Switch:SW_Push SW1
U 1 1 5E914CFC
P 1150 1400
F 0 "SW1" V 1104 1548 50  0000 L CNN
F 1 "SW_Push" V 1195 1548 50  0001 L CNN
F 2 "Button_Switch_SMD:SW_SPST_CK_RS282G05A3" H 1150 1600 50  0001 C CNN
F 3 "~" H 1150 1600 50  0001 C CNN
	1    1150 1400
	0    1    1    0   
$EndComp
Wire Wire Line
	1150 1200 1600 1200
Wire Wire Line
	1600 1500 1600 1600
Wire Wire Line
	1600 1600 1400 1600
Connection ~ 1400 1600
Wire Wire Line
	1400 1600 1150 1600
$EndSCHEMATC
