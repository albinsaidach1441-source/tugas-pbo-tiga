/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum3.praktek;

/**
 *
 * @author user
 */
// Interface utama
interface Sports {
    void setHomeTeam(String name);
    void setVisitingTeam(String name);
}

// Interface turunan Football
interface Football extends Sports {
    void homeTeamScored(int points);
    void visitingTeamScored(int points);
    void endOfQuarter(int quarter);
}

// Interface turunan Hockey
interface Hockey extends Sports {
    void homeGoalScored();
    void visitingGoalScored();
    void endOfPeriod(int period);
    void overtimePeriod(int ot);
}

// Interface Event
interface Event {
    void organize();
}

// Implementasi kelas HockeyDemo
public class HockeyDemo implements Hockey, Event {

    @Override
    public void setHomeTeam(String name) {
        System.out.println("Home team: " + name);
    }

    @Override
    public void setVisitingTeam(String name) {
        // Bisa ditambahkan logika sesuai kebutuhan
    }

    @Override
    public void homeGoalScored() {
        // Implementasi kosong sementara
    }

    @Override
    public void visitingGoalScored() {
        // Implementasi kosong sementara
    }

    @Override
    public void endOfPeriod(int period) {
        // Implementasi kosong sementara
    }

    @Override
    public void overtimePeriod(int ot) {
        // Implementasi kosong sementara
    }

    @Override
    public void organize() {
        System.out.println("Match organized.");
    }

    // Main method
    public static void main(String[] args) {
        HockeyDemo hockeyDemo = new HockeyDemo();
        hockeyDemo.setHomeTeam("India");
        hockeyDemo.organize();
    }
}