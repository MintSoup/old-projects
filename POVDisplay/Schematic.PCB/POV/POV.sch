EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr User 11811 11811
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
Text GLabel 3800 2550 2    50   Input ~ 0
SWDIO
Text GLabel 3800 2650 2    50   Input ~ 0
SWDCLK
$Comp
L power:+3V3 #PWR012
U 1 1 5EB728CB
P 2200 1200
F 0 "#PWR012" H 2200 1050 50  0001 C CNN
F 1 "+3V3" H 2215 1373 50  0000 C CNN
F 2 "" H 2200 1200 50  0001 C CNN
F 3 "" H 2200 1200 50  0001 C CNN
	1    2200 1200
	1    0    0    -1  
$EndComp
Wire Wire Line
	2200 1200 2200 1250
Wire Wire Line
	2200 1250 2250 1250
Wire Wire Line
	2650 1450 2550 1450
$Comp
L Device:R R5
U 1 1 5EB6CE8B
P 2400 1450
F 0 "R5" V 2300 1450 50  0000 C CNN
F 1 "10K" V 2400 1450 50  0000 C CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 2330 1450 50  0001 C CNN
F 3 "~" H 2400 1450 50  0001 C CNN
	1    2400 1450
	0    1    1    0   
$EndComp
$Comp
L power:GND #PWR025
U 1 1 5EC2D6BF
P 4650 2000
F 0 "#PWR025" H 4650 1750 50  0001 C CNN
F 1 "GND" H 4655 1827 50  0000 C CNN
F 2 "" H 4650 2000 50  0001 C CNN
F 3 "" H 4650 2000 50  0001 C CNN
	1    4650 2000
	1    0    0    -1  
$EndComp
$Comp
L Device:C C7
U 1 1 5EF825AE
P 5450 2350
F 0 "C7" H 5250 2400 50  0000 L CNN
F 1 "100n" H 5150 2300 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 5488 2200 50  0001 C CNN
F 3 "~" H 5450 2350 50  0001 C CNN
	1    5450 2350
	-1   0    0    -1  
$EndComp
$Comp
L power:+3V3 #PWR028
U 1 1 5EF865C6
P 5900 2150
F 0 "#PWR028" H 5900 2000 50  0001 C CNN
F 1 "+3V3" H 5915 2323 50  0000 C CNN
F 2 "" H 5900 2150 50  0001 C CNN
F 3 "" H 5900 2150 50  0001 C CNN
	1    5900 2150
	1    0    0    -1  
$EndComp
$Comp
L Device:C C8
U 1 1 5EF87312
P 5900 2350
F 0 "C8" H 5700 2400 50  0000 L CNN
F 1 "100n" H 5600 2300 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 5938 2200 50  0001 C CNN
F 3 "~" H 5900 2350 50  0001 C CNN
	1    5900 2350
	-1   0    0    -1  
$EndComp
$Comp
L Device:C C9
U 1 1 5EF87684
P 6300 2350
F 0 "C9" H 6100 2400 50  0000 L CNN
F 1 "100n" H 6000 2300 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 6338 2200 50  0001 C CNN
F 3 "~" H 6300 2350 50  0001 C CNN
	1    6300 2350
	-1   0    0    -1  
$EndComp
Wire Wire Line
	5450 2200 5450 2150
Wire Wire Line
	5450 2150 5900 2150
Wire Wire Line
	5900 2200 5900 2150
Connection ~ 5900 2150
Wire Wire Line
	6300 2200 6300 2150
Wire Wire Line
	5450 2500 5450 2550
Wire Wire Line
	5450 2550 5900 2550
Wire Wire Line
	5900 2500 5900 2550
Connection ~ 5900 2550
Wire Wire Line
	6300 2500 6300 2550
$Comp
L power:GND #PWR029
U 1 1 5EFB8593
P 5900 2550
F 0 "#PWR029" H 5900 2300 50  0001 C CNN
F 1 "GND" H 5905 2377 50  0000 C CNN
F 2 "" H 5900 2550 50  0001 C CNN
F 3 "" H 5900 2550 50  0001 C CNN
	1    5900 2550
	1    0    0    -1  
$EndComp
Wire Wire Line
	2550 1250 2600 1250
Wire Wire Line
	2600 1250 2600 1550
Wire Wire Line
	2600 1550 2350 1550
Connection ~ 2600 1250
Wire Wire Line
	2600 1250 2650 1250
$Comp
L power:GND #PWR014
U 1 1 5EFEF075
P 2350 2050
F 0 "#PWR014" H 2350 1800 50  0001 C CNN
F 1 "GND" H 2355 1877 50  0000 C CNN
F 2 "" H 2350 2050 50  0001 C CNN
F 3 "" H 2350 2050 50  0001 C CNN
	1    2350 2050
	1    0    0    -1  
$EndComp
$Comp
L Sensor_Magnetic:A3144E U1
U 1 1 5EFF6197
P 1350 3400
F 0 "U1" H 1600 4065 50  0000 C CNN
F 1 "A3144E" H 1600 3974 50  0000 C CNN
F 2 "Package_TO_SOT_THT:TO-92_Inline_Horizontal2" H 1350 3400 50  0001 C CNN
F 3 "" H 1350 3400 50  0001 C CNN
	1    1350 3400
	1    0    0    -1  
$EndComp
Wire Wire Line
	1250 2750 1250 3000
Wire Wire Line
	1250 3000 1300 3000
Wire Wire Line
	1250 3450 1250 3200
Wire Wire Line
	1250 3200 1300 3200
$Comp
L power:+5V #PWR02
U 1 1 5F054AB5
P 1250 2750
F 0 "#PWR02" H 1250 2600 50  0001 C CNN
F 1 "+5V" H 1265 2923 50  0000 C CNN
F 2 "" H 1250 2750 50  0001 C CNN
F 3 "" H 1250 2750 50  0001 C CNN
	1    1250 2750
	-1   0    0    -1  
$EndComp
$Comp
L Device:R R3
U 1 1 5F057981
P 1950 2900
F 0 "R3" H 1800 2900 50  0000 L CNN
F 1 "1K" H 2020 2855 50  0001 L CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 1880 2900 50  0001 C CNN
F 3 "~" H 1950 2900 50  0001 C CNN
	1    1950 2900
	-1   0    0    -1  
$EndComp
Wire Wire Line
	1950 3050 1950 3100
Wire Wire Line
	1950 3100 1900 3100
$Comp
L power:+5V #PWR09
U 1 1 5F0799BA
P 1950 2750
F 0 "#PWR09" H 1950 2600 50  0001 C CNN
F 1 "+5V" H 1965 2923 50  0000 C CNN
F 2 "" H 1950 2750 50  0001 C CNN
F 3 "" H 1950 2750 50  0001 C CNN
	1    1950 2750
	-1   0    0    -1  
$EndComp
$Comp
L Device:R R4
U 1 1 5F24C0EA
P 2400 1250
F 0 "R4" V 2300 1250 50  0000 C CNN
F 1 "10K" V 2400 1250 50  0000 C CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 2330 1250 50  0001 C CNN
F 3 "~" H 2400 1250 50  0001 C CNN
	1    2400 1250
	0    1    1    0   
$EndComp
$Comp
L MCU_ST_STM32F0:STM32F051K6Ux U3
U 1 1 5EDD3904
P 3250 1950
F 0 "U3" H 2800 900 50  0000 C CNN
F 1 "STM32F051K6Ux" H 2850 1000 50  0000 C CNN
F 2 "Package_DFN_QFN:QFN-32-1EP_5x5mm_P0.5mm_EP3.45x3.45mm" H 2750 1050 50  0001 R CNN
F 3 "http://www.st.com/st-web-ui/static/active/en/resource/technical/document/datasheet/DM00039193.pdf" H 3250 1950 50  0001 C CNN
	1    3250 1950
	1    0    0    -1  
$EndComp
$Comp
L power:+3V3 #PWR018
U 1 1 5EDD6CFA
P 3250 1000
F 0 "#PWR018" H 3250 850 50  0001 C CNN
F 1 "+3V3" H 3265 1173 50  0000 C CNN
F 2 "" H 3250 1000 50  0001 C CNN
F 3 "" H 3250 1000 50  0001 C CNN
	1    3250 1000
	1    0    0    -1  
$EndComp
Wire Wire Line
	3150 1050 3150 1000
Wire Wire Line
	3150 1000 3250 1000
Wire Wire Line
	3350 1000 3350 1050
Connection ~ 3250 1000
Wire Wire Line
	3250 1000 3350 1000
Wire Wire Line
	3250 1050 3250 1000
$Comp
L power:GND #PWR019
U 1 1 5EDDFA8C
P 3250 2950
F 0 "#PWR019" H 3250 2700 50  0001 C CNN
F 1 "GND" H 3250 2800 50  0000 C CNN
F 2 "" H 3250 2950 50  0001 C CNN
F 3 "" H 3250 2950 50  0001 C CNN
	1    3250 2950
	1    0    0    -1  
$EndComp
Text GLabel 3800 1850 2    50   Input ~ 0
DIN
Wire Wire Line
	3750 1850 3800 1850
Text GLabel 7650 750  0    50   Input ~ 0
DIN
Connection ~ 8100 4000
Wire Wire Line
	8100 4650 8000 4650
Wire Wire Line
	8100 4000 8100 4650
Wire Wire Line
	7300 4650 7300 4000
Connection ~ 7300 4650
Wire Wire Line
	7400 4650 7300 4650
Connection ~ 8100 3350
Wire Wire Line
	8100 4000 8000 4000
Wire Wire Line
	8100 3350 8100 4000
Connection ~ 8100 2700
Wire Wire Line
	8100 3350 8000 3350
Wire Wire Line
	8100 2700 8100 3350
Connection ~ 8100 2050
Wire Wire Line
	8100 2700 8000 2700
Wire Wire Line
	8100 2050 8100 2700
Connection ~ 8100 1400
Wire Wire Line
	8100 2050 8000 2050
Wire Wire Line
	8100 1400 8100 2050
Wire Wire Line
	8100 1400 8100 1300
Wire Wire Line
	8000 1400 8100 1400
$Comp
L power:+5V #PWR033
U 1 1 5EE86C77
P 8100 1300
F 0 "#PWR033" H 8100 1150 50  0001 C CNN
F 1 "+5V" H 8115 1473 50  0000 C CNN
F 2 "" H 8100 1300 50  0001 C CNN
F 3 "" H 8100 1300 50  0001 C CNN
	1    8100 1300
	1    0    0    -1  
$EndComp
Connection ~ 7300 2050
Wire Wire Line
	7300 1400 7400 1400
Wire Wire Line
	7300 2050 7300 1400
Connection ~ 7300 2700
Wire Wire Line
	7300 2050 7400 2050
Wire Wire Line
	7300 2700 7300 2050
Connection ~ 7300 3350
Wire Wire Line
	7300 2700 7400 2700
Wire Wire Line
	7300 3350 7300 2700
Connection ~ 7300 4000
Wire Wire Line
	7300 3350 7400 3350
Wire Wire Line
	7300 4000 7300 3350
Wire Wire Line
	7300 4000 7400 4000
Wire Wire Line
	7300 4800 7300 4650
$Comp
L power:GND #PWR032
U 1 1 5EE6FBA8
P 7300 4800
F 0 "#PWR032" H 7300 4550 50  0001 C CNN
F 1 "GND" H 7305 4627 50  0000 C CNN
F 2 "" H 7300 4800 50  0001 C CNN
F 3 "" H 7300 4800 50  0001 C CNN
	1    7300 4800
	1    0    0    -1  
$EndComp
Wire Wire Line
	7700 4300 7700 4350
Wire Wire Line
	7700 3650 7700 3700
Wire Wire Line
	7700 3000 7700 3050
Wire Wire Line
	7700 2350 7700 2400
Wire Wire Line
	7700 1700 7700 1750
$Comp
L LED:WS2812B D4
U 1 1 5EE1CE0E
P 7700 1400
F 0 "D4" H 8044 1446 50  0001 L CNN
F 1 "WS2812B" H 8044 1355 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 7750 1100 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 7800 1025 50  0001 L TNN
	1    7700 1400
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D5
U 1 1 5EE1C977
P 7700 2050
F 0 "D5" H 8044 2096 50  0001 L CNN
F 1 "WS2812B" H 8044 2005 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 7750 1750 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 7800 1675 50  0001 L TNN
	1    7700 2050
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D6
U 1 1 5EE09542
P 7700 2700
F 0 "D6" H 8044 2746 50  0001 L CNN
F 1 "WS2812B" H 8044 2655 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 7750 2400 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 7800 2325 50  0001 L TNN
	1    7700 2700
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D7
U 1 1 5EE08F9D
P 7700 3350
F 0 "D7" H 8044 3396 50  0001 L CNN
F 1 "WS2812B" H 8044 3305 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 7750 3050 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 7800 2975 50  0001 L TNN
	1    7700 3350
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D8
U 1 1 5EE13951
P 7700 4000
F 0 "D8" H 8044 4046 50  0001 L CNN
F 1 "WS2812B" H 8044 3955 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 7750 3700 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 7800 3625 50  0001 L TNN
	1    7700 4000
	0    1    1    0   
$EndComp
Connection ~ 9200 4000
Wire Wire Line
	9200 4650 9100 4650
Wire Wire Line
	9200 4000 9200 4650
Wire Wire Line
	8400 4650 8400 4000
Connection ~ 8400 4650
Wire Wire Line
	8500 4650 8400 4650
Connection ~ 9200 3350
Wire Wire Line
	9200 4000 9100 4000
Wire Wire Line
	9200 3350 9200 4000
Connection ~ 9200 2700
Wire Wire Line
	9200 3350 9100 3350
Wire Wire Line
	9200 2700 9200 3350
Connection ~ 9200 2050
Wire Wire Line
	9200 2700 9100 2700
Wire Wire Line
	9200 2050 9200 2700
Connection ~ 9200 1400
Wire Wire Line
	9200 2050 9100 2050
Wire Wire Line
	9200 1400 9200 2050
Wire Wire Line
	9200 1400 9200 1300
Wire Wire Line
	9100 1400 9200 1400
$Comp
L power:+5V #PWR035
U 1 1 5EEC7841
P 9200 1300
F 0 "#PWR035" H 9200 1150 50  0001 C CNN
F 1 "+5V" H 9215 1473 50  0000 C CNN
F 2 "" H 9200 1300 50  0001 C CNN
F 3 "" H 9200 1300 50  0001 C CNN
	1    9200 1300
	1    0    0    -1  
$EndComp
Connection ~ 8400 2050
Wire Wire Line
	8400 1400 8500 1400
Wire Wire Line
	8400 2050 8400 1400
Connection ~ 8400 2700
Wire Wire Line
	8400 2050 8500 2050
Wire Wire Line
	8400 2700 8400 2050
Connection ~ 8400 3350
Wire Wire Line
	8400 2700 8500 2700
Wire Wire Line
	8400 3350 8400 2700
Connection ~ 8400 4000
Wire Wire Line
	8400 3350 8500 3350
Wire Wire Line
	8400 4000 8400 3350
Wire Wire Line
	8400 4000 8500 4000
Wire Wire Line
	8400 4800 8400 4650
$Comp
L power:GND #PWR034
U 1 1 5EEC7859
P 8400 4800
F 0 "#PWR034" H 8400 4550 50  0001 C CNN
F 1 "GND" H 8405 4627 50  0000 C CNN
F 2 "" H 8400 4800 50  0001 C CNN
F 3 "" H 8400 4800 50  0001 C CNN
	1    8400 4800
	1    0    0    -1  
$EndComp
Wire Wire Line
	8800 4300 8800 4350
Wire Wire Line
	8800 3650 8800 3700
Wire Wire Line
	8800 3000 8800 3050
Wire Wire Line
	8800 2350 8800 2400
Wire Wire Line
	8800 1700 8800 1750
$Comp
L LED:WS2812B D15
U 1 1 5EEC7868
P 8800 4650
F 0 "D15" H 9144 4696 50  0001 L CNN
F 1 "WS2812B" H 9144 4605 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 8850 4350 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 8900 4275 50  0001 L TNN
	1    8800 4650
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D10
U 1 1 5EEC7872
P 8800 1400
F 0 "D10" H 9144 1446 50  0001 L CNN
F 1 "WS2812B" H 9144 1355 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 8850 1100 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 8900 1025 50  0001 L TNN
	1    8800 1400
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D11
U 1 1 5EEC787C
P 8800 2050
F 0 "D11" H 9144 2096 50  0001 L CNN
F 1 "WS2812B" H 9144 2005 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 8850 1750 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 8900 1675 50  0001 L TNN
	1    8800 2050
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D12
U 1 1 5EEC7886
P 8800 2700
F 0 "D12" H 9144 2746 50  0001 L CNN
F 1 "WS2812B" H 9144 2655 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 8850 2400 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 8900 2325 50  0001 L TNN
	1    8800 2700
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D13
U 1 1 5EEC7890
P 8800 3350
F 0 "D13" H 9144 3396 50  0001 L CNN
F 1 "WS2812B" H 9144 3305 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 8850 3050 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 8900 2975 50  0001 L TNN
	1    8800 3350
	0    1    1    0   
$EndComp
$Comp
L LED:WS2812B D14
U 1 1 5EEC789A
P 8800 4000
F 0 "D14" H 9144 4046 50  0001 L CNN
F 1 "WS2812B" H 9144 3955 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 8850 3700 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 8900 3625 50  0001 L TNN
	1    8800 4000
	0    1    1    0   
$EndComp
Wire Wire Line
	8800 950  8800 1100
Wire Wire Line
	8250 950  8800 950 
$Comp
L Device:R R10
U 1 1 5EF0AE86
P 7700 950
F 0 "R10" H 7500 950 50  0000 L CNN
F 1 "470R" H 7770 905 50  0000 L CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 7630 950 50  0001 C CNN
F 3 "~" H 7700 950 50  0001 C CNN
	1    7700 950 
	-1   0    0    1   
$EndComp
Wire Wire Line
	7650 750  7700 750 
Wire Wire Line
	7700 750  7700 800 
Wire Wire Line
	3800 2550 3750 2550
Wire Wire Line
	3750 2650 3800 2650
Wire Wire Line
	4650 1600 4650 1650
Text GLabel 4600 1250 0    50   Input ~ 0
BATT
Wire Wire Line
	4600 1250 4650 1250
Wire Wire Line
	4650 1250 4650 1300
$Comp
L Device:R R6
U 1 1 5F05A567
P 4650 1450
F 0 "R6" H 4500 1450 50  0000 L CNN
F 1 "~" H 4720 1405 50  0000 L CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 4580 1450 50  0001 C CNN
F 3 "~" H 4650 1450 50  0001 C CNN
	1    4650 1450
	1    0    0    -1  
$EndComp
$Comp
L Device:R R7
U 1 1 5F05A782
P 4650 1850
F 0 "R7" H 4500 1850 50  0000 L CNN
F 1 "~" H 4720 1805 50  0000 L CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 4580 1850 50  0001 C CNN
F 3 "~" H 4650 1850 50  0001 C CNN
	1    4650 1850
	1    0    0    -1  
$EndComp
Connection ~ 4650 1650
Wire Wire Line
	4650 1650 4650 1700
Wire Wire Line
	2350 1550 2350 1750
$Comp
L Device:C C5
U 1 1 5EFCA8B4
P 2350 1900
F 0 "C5" H 2550 1950 50  0000 L CNN
F 1 "100n" H 2450 1850 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 2388 1750 50  0001 C CNN
F 3 "~" H 2350 1900 50  0001 C CNN
	1    2350 1900
	-1   0    0    -1  
$EndComp
Wire Wire Line
	2650 2250 2450 2250
Wire Wire Line
	2450 2250 2450 3100
Wire Wire Line
	2450 3100 1950 3100
Connection ~ 1950 3100
$Comp
L power:GND #PWR03
U 1 1 5F03B9E5
P 1250 3450
F 0 "#PWR03" H 1250 3200 50  0001 C CNN
F 1 "GND" H 1255 3277 50  0000 C CNN
F 2 "" H 1250 3450 50  0001 C CNN
F 3 "" H 1250 3450 50  0001 C CNN
	1    1250 3450
	-1   0    0    -1  
$EndComp
Text GLabel 3750 2150 2    50   Input ~ 0
TX
Text GLabel 3750 2250 2    50   Input ~ 0
RX
Wire Wire Line
	5900 2150 6300 2150
Wire Wire Line
	5900 2550 6300 2550
Wire Wire Line
	3750 1650 4650 1650
NoConn ~ 3750 2750
NoConn ~ 3750 2450
NoConn ~ 3750 2350
NoConn ~ 3750 1950
NoConn ~ 3750 2050
NoConn ~ 3750 1550
NoConn ~ 3750 1450
NoConn ~ 3750 1350
NoConn ~ 3750 1250
NoConn ~ 2650 1950
NoConn ~ 2650 2050
NoConn ~ 2650 2150
NoConn ~ 2650 2350
NoConn ~ 2650 2550
NoConn ~ 2650 2450
NoConn ~ 2650 2650
NoConn ~ 2650 2750
$Comp
L power:GND #PWR013
U 1 1 5F234B48
P 2200 1500
F 0 "#PWR013" H 2200 1250 50  0001 C CNN
F 1 "GND" H 2205 1327 50  0000 C CNN
F 2 "" H 2200 1500 50  0001 C CNN
F 3 "" H 2200 1500 50  0001 C CNN
	1    2200 1500
	1    0    0    -1  
$EndComp
Wire Wire Line
	2200 1500 2200 1450
Wire Wire Line
	2200 1450 2250 1450
NoConn ~ 3750 1750
NoConn ~ 8800 4950
Wire Wire Line
	3550 10350 3550 10200
Connection ~ 3550 10350
Wire Wire Line
	3400 10350 3550 10350
Wire Wire Line
	3400 10250 3400 10350
Wire Wire Line
	3550 9850 3550 10000
Connection ~ 3550 9850
Wire Wire Line
	3400 9850 3400 9950
Wire Wire Line
	3400 9850 3550 9850
Wire Wire Line
	3550 9700 3550 9850
$Comp
L Device:C C6
U 1 1 5F265BB4
P 3400 10100
F 0 "C6" H 3200 10150 50  0000 L CNN
F 1 "22u" H 3150 10050 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 3438 9950 50  0001 C CNN
F 3 "~" H 3400 10100 50  0001 C CNN
	1    3400 10100
	1    0    0    -1  
$EndComp
$Comp
L Regulator_Linear:SP6203 U4
U 1 1 5EBE5DB9
P 3750 10350
F 0 "U4" H 3925 10965 50  0000 C CNN
F 1 "SP6203" H 3925 10874 50  0000 C CNN
F 2 "Package_TO_SOT_SMD:SOT-23-5_HandSoldering" H 3750 10350 50  0001 C CNN
F 3 "" H 3750 10350 50  0001 C CNN
	1    3750 10350
	1    0    0    -1  
$EndComp
$Comp
L power:+5V #PWR020
U 1 1 5EBE7E12
P 3550 9700
F 0 "#PWR020" H 3550 9550 50  0001 C CNN
F 1 "+5V" H 3565 9873 50  0000 C CNN
F 2 "" H 3550 9700 50  0001 C CNN
F 3 "" H 3550 9700 50  0001 C CNN
	1    3550 9700
	1    0    0    -1  
$EndComp
Wire Wire Line
	3550 10000 3600 10000
Wire Wire Line
	3600 10100 3550 10100
Wire Wire Line
	3550 10100 3550 10000
Connection ~ 3550 10000
Wire Wire Line
	4300 10000 4250 10000
Wire Wire Line
	4300 9700 4300 10000
$Comp
L power:+3V3 #PWR024
U 1 1 5EBFD197
P 4300 9700
F 0 "#PWR024" H 4300 9550 50  0001 C CNN
F 1 "+3V3" H 4315 9873 50  0000 C CNN
F 2 "" H 4300 9700 50  0001 C CNN
F 3 "" H 4300 9700 50  0001 C CNN
	1    4300 9700
	1    0    0    -1  
$EndComp
Wire Wire Line
	3550 10200 3600 10200
Wire Wire Line
	3550 10450 3550 10350
$Comp
L power:GND #PWR021
U 1 1 5EBED9E2
P 3550 10450
F 0 "#PWR021" H 3550 10200 50  0001 C CNN
F 1 "GND" H 3555 10277 50  0000 C CNN
F 2 "" H 3550 10450 50  0001 C CNN
F 3 "" H 3550 10450 50  0001 C CNN
	1    3550 10450
	1    0    0    -1  
$EndComp
NoConn ~ 4250 10200
Text GLabel 3050 9850 2    50   Input ~ 0
BATT
NoConn ~ 2650 9950
$Comp
L Connector:Conn_01x02_Male BATT1
U 1 1 5EB80A64
P 800 8050
F 0 "BATT1" H 908 8139 50  0000 C CNN
F 1 "Conn_01x02_Male" H 908 8140 50  0001 C CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x02_P2.54mm_Vertical" H 800 8050 50  0001 C CNN
F 3 "~" H 800 8050 50  0001 C CNN
	1    800  8050
	1    0    0    -1  
$EndComp
$Comp
L power:GND #PWR01
U 1 1 5EB844CA
P 1050 8200
F 0 "#PWR01" H 1050 7950 50  0001 C CNN
F 1 "GND" H 1055 8027 50  0000 C CNN
F 2 "" H 1050 8200 50  0001 C CNN
F 3 "" H 1050 8200 50  0001 C CNN
	1    1050 8200
	1    0    0    -1  
$EndComp
Wire Wire Line
	1050 8050 1000 8050
Wire Wire Line
	1050 8200 1050 8150
Wire Wire Line
	1050 8150 1000 8150
Wire Wire Line
	1850 8000 1850 8050
Wire Wire Line
	1850 8050 1800 8050
Wire Wire Line
	1850 8400 1850 8350
Wire Wire Line
	1850 8350 1800 8350
$Comp
L power:GND #PWR08
U 1 1 5EBB16A0
P 1850 8400
F 0 "#PWR08" H 1850 8150 50  0001 C CNN
F 1 "GND" H 1855 8227 50  0000 C CNN
F 2 "" H 1850 8400 50  0001 C CNN
F 3 "" H 1850 8400 50  0001 C CNN
	1    1850 8400
	1    0    0    -1  
$EndComp
$Comp
L power:+3V3 #PWR07
U 1 1 5EBB2047
P 1850 8000
F 0 "#PWR07" H 1850 7850 50  0001 C CNN
F 1 "+3V3" H 1865 8173 50  0000 C CNN
F 2 "" H 1850 8000 50  0001 C CNN
F 3 "" H 1850 8000 50  0001 C CNN
	1    1850 8000
	1    0    0    -1  
$EndComp
Text GLabel 1050 8050 2    50   Input ~ 0
BATT
Wire Notes Line
	650  11150 650  8950
Text Notes 700  9150 0    118  ~ 0
POWER\n
Text Notes 700  7750 0    79   ~ 0
CONNECTORS\n
$Comp
L Switch:SW_SPDT SW1
U 1 1 5F2148D6
P 2850 9750
F 0 "SW1" H 2850 10035 50  0001 C CNN
F 1 "SW_SPDT" H 2850 9944 50  0001 C CNN
F 2 "Button_Switch_SMD:SW_SPDT_CK-JS102011SAQN" H 2850 9750 50  0001 C CNN
F 3 "~" H 2850 9750 50  0001 C CNN
	1    2850 9750
	1    0    0    -1  
$EndComp
$Comp
L power:GND #PWR015
U 1 1 5EE00EDF
P 2400 10050
F 0 "#PWR015" H 2400 9800 50  0001 C CNN
F 1 "GND" H 2405 9877 50  0000 C CNN
F 2 "" H 2400 10050 50  0001 C CNN
F 3 "" H 2400 10050 50  0001 C CNN
	1    2400 10050
	1    0    0    -1  
$EndComp
Text GLabel 2400 9650 2    50   Input ~ 0
BATT
$Comp
L Device:L L1
U 1 1 5EBD1063
P 1450 9650
F 0 "L1" V 1549 9650 50  0000 C CNN
F 1 "L" V 1549 9650 50  0001 C CNN
F 2 "Inductor_SMD:L_1210_3225Metric_Pad1.42x2.65mm_HandSolder" H 1450 9650 50  0001 C CNN
F 3 "~" H 1450 9650 50  0001 C CNN
	1    1450 9650
	0    1    -1   0   
$EndComp
$Comp
L Converter_DCDC:MT3608 U2
U 1 1 5EE66167
P 2050 9750
F 0 "U2" H 2025 10115 50  0000 C CNN
F 1 "MT3608" H 2025 10024 50  0000 C CNN
F 2 "Package_TO_SOT_SMD:SOT-23-6_Handsoldering" H 2000 9500 50  0001 C CNN
F 3 "" H 2000 9500 50  0001 C CNN
	1    2050 9750
	1    0    0    -1  
$EndComp
Wire Wire Line
	2400 10050 2400 9850
Wire Wire Line
	2400 9850 2350 9850
Wire Wire Line
	2400 9650 2350 9650
Wire Wire Line
	1700 9650 1650 9650
$Comp
L Device:D_Schottky D1
U 1 1 5EECAE67
P 1650 9500
F 0 "D1" V 1650 9550 50  0000 L CNN
F 1 "D_Schottky" V 1695 9579 50  0001 L CNN
F 2 "Diode_SMD:D_0603_1608Metric_Castellated" H 1650 9500 50  0001 C CNN
F 3 "~" H 1650 9500 50  0001 C CNN
	1    1650 9500
	0    1    1    0   
$EndComp
Connection ~ 1650 9650
Wire Wire Line
	1650 9650 1600 9650
Text GLabel 1250 9650 0    50   Input ~ 0
BATT
Wire Wire Line
	1250 9650 1300 9650
Wire Wire Line
	2350 9750 2650 9750
$Comp
L power:+5V #PWR06
U 1 1 5EEE7474
P 1650 9350
F 0 "#PWR06" H 1650 9200 50  0001 C CNN
F 1 "+5V" H 1665 9523 50  0000 C CNN
F 2 "" H 1650 9350 50  0001 C CNN
F 3 "" H 1650 9350 50  0001 C CNN
	1    1650 9350
	1    0    0    -1  
$EndComp
$Comp
L power:+5V #PWR04
U 1 1 5EEE9A5F
P 1250 9950
F 0 "#PWR04" H 1250 9800 50  0001 C CNN
F 1 "+5V" H 1265 10123 50  0000 C CNN
F 2 "" H 1250 9950 50  0001 C CNN
F 3 "" H 1250 9950 50  0001 C CNN
	1    1250 9950
	1    0    0    -1  
$EndComp
$Comp
L power:GND #PWR05
U 1 1 5EF0E400
P 1250 10850
F 0 "#PWR05" H 1250 10600 50  0001 C CNN
F 1 "GND" H 1255 10677 50  0000 C CNN
F 2 "" H 1250 10850 50  0001 C CNN
F 3 "" H 1250 10850 50  0001 C CNN
	1    1250 10850
	1    0    0    -1  
$EndComp
Wire Wire Line
	1250 10000 1250 10050
$Comp
L Device:R R1
U 1 1 5EF0E40E
P 1250 10200
F 0 "R1" H 1100 10200 50  0000 L CNN
F 1 "~" H 1320 10155 50  0000 L CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 1180 10200 50  0001 C CNN
F 3 "~" H 1250 10200 50  0001 C CNN
	1    1250 10200
	1    0    0    -1  
$EndComp
$Comp
L Device:R R2
U 1 1 5EF0E418
P 1250 10600
F 0 "R2" H 1100 10600 50  0000 L CNN
F 1 "~" H 1320 10555 50  0000 L CNN
F 2 "Resistor_SMD:R_0603_1608Metric" V 1180 10600 50  0001 C CNN
F 3 "~" H 1250 10600 50  0001 C CNN
	1    1250 10600
	1    0    0    -1  
$EndComp
Wire Wire Line
	1250 10350 1250 10400
Wire Wire Line
	1250 10400 1500 10400
Wire Wire Line
	1500 10400 1500 9850
Wire Wire Line
	1500 9850 1700 9850
Connection ~ 1250 10400
Wire Wire Line
	1250 10400 1250 10450
$Comp
L Device:C C1
U 1 1 5EFFF25D
P 800 10400
F 0 "C1" H 600 10450 50  0000 L CNN
F 1 "22u" H 550 10350 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 838 10250 50  0001 C CNN
F 3 "~" H 800 10400 50  0001 C CNN
	1    800  10400
	-1   0    0    -1  
$EndComp
Wire Wire Line
	800  10250 800  10000
Wire Wire Line
	800  10000 1250 10000
Connection ~ 1250 10000
Wire Wire Line
	1250 9950 1250 10000
Wire Wire Line
	800  10550 800  10800
Wire Wire Line
	800  10800 1250 10800
Wire Wire Line
	1250 10800 1250 10850
Wire Wire Line
	1250 10800 1250 10750
Connection ~ 1250 10800
$Comp
L Device:C C3
U 1 1 5F027093
P 2150 10600
F 0 "C3" H 1950 10650 50  0000 L CNN
F 1 "22u" H 1900 10550 50  0000 L CNN
F 2 "Capacitor_SMD:C_0603_1608Metric" H 2188 10450 50  0001 C CNN
F 3 "~" H 2150 10600 50  0001 C CNN
	1    2150 10600
	-1   0    0    -1  
$EndComp
Text GLabel 2100 10400 0    50   Input ~ 0
BATT
Wire Wire Line
	2150 10400 2150 10450
Wire Wire Line
	2100 10400 2150 10400
$Comp
L power:GND #PWR011
U 1 1 5F03DC38
P 2150 10800
F 0 "#PWR011" H 2150 10550 50  0001 C CNN
F 1 "GND" H 2155 10627 50  0000 C CNN
F 2 "" H 2150 10800 50  0001 C CNN
F 3 "" H 2150 10800 50  0001 C CNN
	1    2150 10800
	1    0    0    -1  
$EndComp
Wire Wire Line
	2150 10800 2150 10750
Wire Wire Line
	8250 5050 8250 950 
Wire Wire Line
	7700 5050 8250 5050
Wire Wire Line
	7700 4950 7700 5050
$Comp
L LED:WS2812B D9
U 1 1 5EE1D64E
P 7700 4650
F 0 "D9" H 8044 4696 50  0001 L CNN
F 1 "WS2812B" H 8044 4605 50  0001 L CNN
F 2 "LED_SMD:LED_WS2812B_PLCC4_5.0x5.0mm_P3.2mm" H 7750 4350 50  0001 L TNN
F 3 "https://cdn-shop.adafruit.com/datasheets/WS2812B.pdf" H 7800 4275 50  0001 L TNN
	1    7700 4650
	0    1    1    0   
$EndComp
$Comp
L power:GND #PWR023
U 1 1 5EFE7B9D
P 2700 8400
F 0 "#PWR023" H 2700 8150 50  0001 C CNN
F 1 "GND" H 2705 8227 50  0000 C CNN
F 2 "" H 2700 8400 50  0001 C CNN
F 3 "" H 2700 8400 50  0001 C CNN
	1    2700 8400
	1    0    0    -1  
$EndComp
Wire Wire Line
	2700 8350 2650 8350
Wire Wire Line
	2700 8400 2700 8350
Text GLabel 2650 8150 2    50   Input ~ 0
RX
Text GLabel 2650 8250 2    50   Input ~ 0
TX
Wire Notes Line
	2900 7600 2900 8650
Wire Notes Line
	2900 8650 650  8650
Wire Notes Line
	650  7600 2900 7600
Wire Notes Line
	650  7600 650  8650
Wire Notes Line
	650  8950 4500 8950
Wire Notes Line
	4500 8950 4500 11150
Wire Notes Line
	4500 11150 650  11150
$Comp
L Connector:Conn_01x03_Male UART1
U 1 1 5EDF845D
P 2450 8250
F 0 "UART1" H 2350 8250 50  0000 C CNN
F 1 "Conn_01x03_Male" H 2558 8440 50  0001 C CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x03_P2.54mm_Vertical" H 2450 8250 50  0001 C CNN
F 3 "~" H 2450 8250 50  0001 C CNN
	1    2450 8250
	1    0    0    -1  
$EndComp
$Comp
L Connector:Conn_01x04_Male SWD1
U 1 1 5EB75623
P 1600 8250
F 0 "SWD1" H 1500 8200 50  0000 C CNN
F 1 "Conn_01x04_Male" H 1800 8400 50  0001 C CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x04_P2.54mm_Vertical" H 1600 8250 50  0001 C CNN
F 3 "~" H 1600 8250 50  0001 C CNN
	1    1600 8250
	1    0    0    1   
$EndComp
Text GLabel 1800 8150 2    50   Input ~ 0
SWDIO
Text GLabel 1800 8250 2    50   Input ~ 0
SWDCLK
$Comp
L Mechanical:MountingHole H1
U 1 1 5EDE59A3
P 2250 7800
F 0 "H1" H 2350 7846 50  0000 L CNN
F 1 "MountingHole" H 2350 7755 50  0000 L CNN
F 2 "MountingHole:MountingHole_2.5mm" H 2250 7800 50  0001 C CNN
F 3 "~" H 2250 7800 50  0001 C CNN
	1    2250 7800
	1    0    0    -1  
$EndComp
$EndSCHEMATC
