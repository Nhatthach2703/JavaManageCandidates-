/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Candidate;
import java.util.ArrayList;

/**
 *
 * @author Xuan Vinh
 */
public interface ICandidateRepository {
    void createNewCandidate(ArrayList<Candidate> candidates, int type);
    
    void searchCandidate(ArrayList<Candidate> candidates);
}
