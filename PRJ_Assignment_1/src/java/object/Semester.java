/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class Semester {
    private String SemesterID;
    private String SemesterName;

    public Semester() {
    }

    public Semester(String SemesterID, String SemesterName) {
        this.SemesterID = SemesterID;
        this.SemesterName = SemesterName;
    }

    public Semester(String SemesterID) {
        this.SemesterID = SemesterID;
    }

    public String getSemesterID() {
        return SemesterID;
    }

    public void setSemesterID(String SemesterID) {
        this.SemesterID = SemesterID;
    }

    public String getSemesterName() {
        return SemesterName;
    }

    public void setSemesterName(String SemesterName) {
        this.SemesterName = SemesterName;
    }

    @Override
    public String toString() {
        return SemesterID + "\n" + SemesterName + "\n\n";
    }
    
    
}
