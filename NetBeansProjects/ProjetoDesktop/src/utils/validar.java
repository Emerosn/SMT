package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.ConnectionFactory;

public class validar {

    public static boolean validarCPF(String CPF) {
        CPF = CPF.replace('.', ' ');
        CPF = CPF.replace('-', ' ');
        CPF = CPF.replaceAll(" ", "");

        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {

            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public int verficarCHOQUE(String CPF) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        String query = "SELECT * FROM pessoa WHERE strCpfPessoa = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, CPF);
        ResultSet rs = stmt.executeQuery();

        rs.last();
        int rowCount = rs.getRow();
        rs.beforeFirst();

        stmt.close();
        rs.close();
        con.close();

        return rowCount;
    }

    public boolean validarEMAIL(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public boolean pregMathString(String nome) {
        String regex = "^[A-ZÀ-Ÿ][A-zÀ-ÿ']+\\s([A-zÀ-ÿ']\\s?)*[A-ZÀ-Ÿ][A-zÀ-ÿ']+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nome);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    public boolean isValidTime(String time) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            Date dataTeste = df.parse(time);
            df.setLenient(false);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }
}
