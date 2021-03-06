package com.sda.app.ui;

import com.sda.app.Bl;
import com.sda.app.masini.db.Masina;
import com.sda.app.utilizatori.db.Utilizator;

import java.util.List;
import java.util.Scanner;

public class Meniu {
    private Bl bl;

    public Meniu(Bl bl) {
        this.bl = bl;
    }

    public void adaugaUtilizator(Scanner scan) {
        System.out.println("Care este numele utilizatorului?");
        String nume = scan.nextLine();
        bl.adaugaUtilizator(new Utilizator(null, nume));
    }

    public void listeazaUtilizatori() {
        List<Utilizator> utilizators = bl.listeazaUtilizatori();
        for (Utilizator u : utilizators) {
            System.out.println("Id: " + u.getId());
            System.out.println("Nume: " + u.getNume());
            System.out.println("--------------------------");
        }
    }

    public void inregistreazaMasinaUnuiUtilizator(Scanner scan) {
        System.out.println("Id_masina = ?");
        Integer id_masina = scan.nextInt();
        System.out.println("Id_utilizator =  ?");
        Integer id_utilizator = scan.nextInt();
        bl.inregistreazaMasinaUnuiUtilizator(id_masina, id_utilizator);
    }

    public void adaugaMasina(Scanner scan) {
        System.out.println("Care este masina de adaugat astfel: marca, model, numar ");
        String marca = scan.nextLine();
        String model = scan.nextLine();
        String numar = scan.nextLine();
        bl.adaugaMasina(new Masina(null, marca, model, numar));
    }

    public void listeazaMasini() {
        List<Masina> masini = bl.listeazaMasini();
        for (Masina m : masini) {
            System.out.println("Id: " + m.getId());
            System.out.println("Marca: " + m.getMarca());
            System.out.println("Model: " + m.getModel());
            System.out.println("Numar: " + m.getNumar());
            System.out.println("--------------------------");
        }
    }

    public void listeazaMasinaUnuiUtilizator(Scanner scan) {
        List<Utilizator> masinaUnuiUtilizator = bl.listeazaMasinaUnuiUtilizator();
        System.out.println("IdUtilizatorMasina =  ?");
        Integer idUtilizatorMasina = scan.nextInt();
        for (Utilizator u : masinaUnuiUtilizator) {
            if (idUtilizatorMasina == u.getId()) {
                System.out.println("Id: " + idUtilizatorMasina);
                System.out.println("nume: " + u.getNume());
                System.out.println("Are masina: " + u.getMasini());
            }
        }
    }

    public void deinregistreazaMasina(Scanner scan) {
        System.out.println("Care este id-ul masinii de deinregistrat ? ");
        Integer idMasinaDeDeinregistrat = scan.nextInt();
        System.out.println("Care este id-ul utiliaztorului ? ");
        Integer idUtilizatoruluiDeLaCareStergemMasina = scan.nextInt();
        Masina masinaDeSters = bl.deinregistreazaMasina(idMasinaDeDeinregistrat,idUtilizatoruluiDeLaCareStergemMasina);

        System.out.println("A fost stearsa masina cu marca: " + masinaDeSters.getMarca() + " de la utilizatorul: " + idMasinaDeDeinregistrat);
    }

    private void printMainMeniu() {
        System.out.println("1. Adauga utilizator");
        System.out.println("2. Adauga masina");
        System.out.println("3. Listeaza utilizatori");
        System.out.println("4. Listeaza masini");
        System.out.println("5. Listeaza masina unui utilizator");
        System.out.println("6. Inregistreaza masina unui utilizator");
        System.out.println("7. Deinregistreaza masina");//stergi masina din lista de masini si stergi asocierile dintre masina si utilizator (in logic utilizator, ca utilizator e ownerul)
        System.out.println("8. Sterge masina");
        System.out.println("9. Sterge utilizator");
        System.out.println("10. Exit");
        System.out.println();
    }

    public void init() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            printMainMeniu();
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    adaugaUtilizator(scan);
                    break;
                case 2:
                    adaugaMasina(scan);
                    break;
                case 3:
                    listeazaUtilizatori();
                    break;
                case 4:
                    listeazaMasini();
                    break;
                case 5:
                    listeazaMasinaUnuiUtilizator(scan);
                    break;
                case 6:
                    inregistreazaMasinaUnuiUtilizator(scan);
                    break;
                case 7:
                    deinregistreazaMasina(scan);
                    break;
                case 10:
                    return;
            }
        }
    }
}
