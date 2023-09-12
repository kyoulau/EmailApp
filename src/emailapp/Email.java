package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private int defaultPasswordLength =10;
    private int mailBoxCapacity=500;
    private String alternateEmail;
    private String companySuffix ="kyoulaucompany.com";

    //construtores para receberrem 1 e last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


        //chama metodo para definir departamento (retorna departamento)
        this.department = this.setDepartment();


        //chamar mudador de senha
        this.password =randomPassword(defaultPasswordLength);
        System.out.println("Sua senha é: "+ this.password);

        //gerar senha aleatoria
        //combinar elementos para gerar email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail() {return alternateEmail;}
    public String getPassword(){return password;}


    public String ImprimirTudo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }

    private String randomPassword(int length){
        String passwordSet = "BCDEFGHIJKLMNOPRSTUVWXYZ123456789!@#$%*";
        char[] password = new char[length];
        for(int i=0; i<length;i++){
            int rand = (int) (Math.random()*passwordSet.length());
            password [i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }

    //set the email capacity
    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }
    //set the alteranative email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    //mudar senha
    public void changePassword(String password){
        this.password = password;
    }

    //perguntar o departamento
    private String setDepartment() {
        System.out.println("Trabalhador- " + firstName +"|" +" Códigos de Departamentos: \n " +
                "1-sales\n " +
                "2-development\n " +
                "3-accounting\n " +
                "0-para nada\n" +
                "Selecione numero: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){return  "sales";}
        else if (depChoice ==2) {return  "dev";}
        else if (depChoice == 3) {return "acct";}
        else {
            return "";
        }

    }
}

