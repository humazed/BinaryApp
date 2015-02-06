package com.example.huma.binaryConvector;


public class Converter {
    //convertButton Binary toSpinner Decimal
    public String ConvertBinToDec(String bi) {
        int[] inputArr;
        int dec = 0;
        //put the input in the int[] toSpinner help in the converting process
        inputArr = new int[bi.length()];
        for (int i = 0; i < bi.length(); i++) {
            inputArr[i] = Integer.parseInt(String.valueOf(bi.charAt(i)));
        }
        //reverse the inputArray
        int[] revArr = new int[bi.length()];
        for (int i = 0, j = bi.length(); i < bi.length(); i++, j--) {
            revArr[i] = inputArr[j - 1];
        }
        //convertButton toSpinner decimal
        for (int i = 0; i < inputArr.length; i++) {
            dec += revArr[i] * Math.pow(2, i);
        }
        return String.valueOf(dec);
    }

    //convertButton binary toSpinner octal
    public String ConvertBinToOct(String bi) {
        return ConvertDecToOct(Integer.parseInt(ConvertBinToDec(bi)));
    }

    //convertButton Binary toSpinner Hexadecimal
    public String ConvertBinToHex(String bi) {
        return ConvertDecToHex(Integer.parseInt(ConvertBinToDec(bi)));
    }

    //convertButton Decimal toSpinner Binary
    public String ConvertDecToBin(int dec) {
        return Integer.toBinaryString(dec);
    }

    //convertButton Decimal toSpinner Octal
    public String ConvertDecToOct(int dec) {
        return Integer.toOctalString(dec);
    }

    //convertButton Decimal toSpinner Hexadecimal
    public String ConvertDecToHex(int dec) {
        return Integer.toHexString(dec);
    }

    //convertButton Octal toSpinner Binary
    public String ConvertOctToBin(String oct) {
        return ConvertDecToBin(Integer.parseInt(ConvertOctToDec(oct)));
    }

    //convertButton Octal toSpinner Decimal
    public String ConvertOctToDec(String oct) {
        int[] inputArr;
        int dec = 0;
        //put the octal in the int[] toSpinner help in the converting process
        inputArr = new int[oct.length()];
        for (int i = 0; i < oct.length(); i++) {
            inputArr[i] = Integer.parseInt(String.valueOf(oct.charAt(i)));
        }
        //reverse the inputArray
        int[] revArr = new int[oct.length()];
        for (int i = 0, j = oct.length(); i < oct.length(); i++, j--) {
            revArr[i] = inputArr[j - 1];
        }
        //convertButton toSpinner Decimal
        for (int i = 0; i < inputArr.length; i++) {
            dec += revArr[i] * Math.pow(8, i);
        }
        return String.valueOf(dec);
    }

    //convertButton Octal toSpinner Hexadecimal
    public String ConvertOctToHex(String oct) {
        return ConvertDecToHex(Integer.parseInt(ConvertOctToDec(oct)));
    }

    //convertButton Hexadecimal toSpinner Binary
    public String ConvertHexToBin(String hex) {
        return ConvertDecToBin(Integer.parseInt(ConvertHexToDec(hex)));
    }

    //convertButton Hexadecimal toSpinner Decimal
    public String ConvertHexToDec(String hex) {
        String[] inputArr;
        int dec = 0;
        //put the hex in the int[] toSpinner help in the converting process
        inputArr = new String[hex.length()];
        for (int i = 0; i < hex.length(); i++) {
            inputArr[i] = String.valueOf(hex.charAt(i));
        }
        //customise the hex and replace litters with it's equivalent number
        String[] customArr = new String[hex.length()];
        for (int i = 0; i < hex.length(); i++) {
            switch (inputArr[i]) {
                case "a":
                    customArr[i] = "10";

                    break;
                case "b":
                    customArr[i] = "11";

                    break;
                case "c":
                    customArr[i] = "12";

                    break;
                case "d":
                    customArr[i] = "13";

                    break;
                case "e":
                    customArr[i] = "14";

                    break;
                case "f":
                    customArr[i] = "15";

                    break;
                default:
                    customArr[i] = inputArr[i];
                    break;
            }
        }
        //reverse the inputArray
        String[] revArr = new String[hex.length()];
        for (int i = 0, j = hex.length(); i < hex.length(); i++, j--) {
            revArr[i] = customArr[j - 1];
        }
        //convertButton toSpinner Decimal
        for (int i = 0; i < inputArr.length; i++) {
            dec += Integer.parseInt(revArr[i]) * Math.pow(16, i);
        }
        return String.valueOf(dec);
    }

    //convertButton Hexadecimal toSpinner Octal
    public String ConvertHexToOct(String hex) {
        return ConvertDecToOct(Integer.parseInt(ConvertHexToDec(hex)));
    }

}
