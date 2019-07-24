package com.company.bashar;

import java.io.*;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String args[]) throws NoSuchAlgorithmException
    {
        final int numberOfTransactionsToTest = 300;

        //parse CSV file and store all the transactions in a TransactionDataModel ArrayList
        OpenCSVReader.parseCSVFile();

        //print the transactions for Test Purpose
//        printTransactions(OpenCSVReader.listOfTransactions);

        ArrayList<TransactionDataModel> transactions =
                geRandomTransactions(OpenCSVReader.listOfTransactions, numberOfTransactionsToTest);

//        printTransactions(transactions);

        CenterOfMassDataModel mainModel =  calculateCenterOfMassForListOfTransactions(transactions);

        System.out.println(mainModel.xPoint);
        System.out.println(mainModel.yPoint);

        //test model by modifying k number of transactions in transactions List
        removeOutputFileContents();
        Random rand = new Random();
        for(int k = 1; k<=10; k++) {
            transactions.remove(k);

            int randomPickIndex = rand.nextInt(OpenCSVReader.listOfTransactions.size() - 1);
            TransactionDataModel pickedTransaction = OpenCSVReader.listOfTransactions.get(randomPickIndex);
            transactions.add(pickedTransaction);

            CenterOfMassDataModel testModel =  calculateCenterOfMassForListOfTransactions(transactions);

            double result = EuclideanDistanceCalculator.calculate(mainModel, testModel);

            String resultStr = "Transaction changed (K) = " + k + "   " + "Euclidean Distance = " + result + "\n";

            System.out.print(resultStr);
            appendResultToFile("output.txt", resultStr);

        }



    }

    private static void printTransactions(ArrayList<TransactionDataModel> list) {

        for (TransactionDataModel item: list) {
            item.printTransactions();
        }
    }

    private static CenterOfMassDataModel calculateCenterOfMassForListOfTransactions(ArrayList<TransactionDataModel> transactions) {
        List<BigInteger> xPoints = new ArrayList();
        List<BigInteger> yPoints = new ArrayList();

        for(TransactionDataModel item : transactions) {
            String concatenatedString = item.buildStringFromTransactions();

            String hashValue = MdFiveHashFunction.getMd5(concatenatedString);
//            System.out.println("Your HashCode length: " + hashValue.length());
//            System.out.println("Your HashCode Generated by MD5 is: " + hashValue);

            String xHashValue = hashValue.substring(0, 16);
            String yHashValue = hashValue.substring(16);

            BigInteger xPoint = new BigInteger(xHashValue, 16);
            BigInteger yPoint = new BigInteger(yHashValue, 16);

            xPoints.add(xPoint);
            yPoints.add(yPoint);

        }

        CenterOfMassDataModel point = new CenterOfMassDataModel(CenterOfMassCalculator.calculateCenterOfAxis(xPoints),
                CenterOfMassCalculator.calculateCenterOfAxis(yPoints));

        return point;
    }

    //select random transactions without repetition
    private static ArrayList<TransactionDataModel> geRandomTransactions(ArrayList<TransactionDataModel> list,
                                                                        int totalItems)
    {
        Random rand = new Random();

        // create a temporary list for storing
        // selected element
        ArrayList<TransactionDataModel> selectedList = new ArrayList<>();

        for (int i = 0; i < totalItems; i++) {

            // take a raundom index between 0 to size of given List
            int randomIndex = rand.nextInt(list.size() - 1);

            // add element in temporary list
            selectedList.add(list.get(randomIndex));

            // Remove selected element from orginal list
            list.remove(randomIndex);
        }
        return selectedList;
    }

    private static void appendResultToFile(String fileName,
                                       String str)
    {
        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName, true));
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }

    private static void removeOutputFileContents() {
        try {
            PrintWriter output = new PrintWriter("output.txt");
            output.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


