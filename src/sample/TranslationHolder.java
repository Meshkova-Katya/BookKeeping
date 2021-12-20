package sample;

import java.util.Date;

public class TranslationHolder {

    private static Date date;
    private static double sum;
    private static String numberOrganization;
    private static int id_transfer;
    private static String viewTransfer;


    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        TranslationHolder.date = date;
    }

    public static double getSum() {
        return sum;
    }

    public static void setSum(double sum) {
        TranslationHolder.sum = sum;
    }

    public static String getNumberOrganization() {
        return numberOrganization;
    }

    public static void setNumberOrganization(String numberOrganization) {
        TranslationHolder.numberOrganization = numberOrganization;
    }

    public static int getId_transfer() {
        return id_transfer;
    }

    public static void setId_transfer(int id_transfer) {
        TranslationHolder.id_transfer = id_transfer;
    }

    public static String getViewTransfer() {
        return viewTransfer;
    }

    public static void setViewTransfer(String viewTransfer) {
        TranslationHolder.viewTransfer = viewTransfer;
    }
}
