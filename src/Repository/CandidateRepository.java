/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAcess.CadidateDAO;
import Model.Candidate;
import java.util.ArrayList;

/**
 *
 * @author Xuan Vinh
 */
public class CandidateRepository implements ICandidateRepositoy{
    private ArrayList<Candidate> candidates;

    public CandidateRepository() {
        candidates = new ArrayList();
    }

    @Override
    public void createNewCandidate(ArrayList<Candidate> candidates, int type) {
        CadidateDAO.Instance().createNewCandidate(candidates, type);
    }

    @Override
    public void searchCandidate(ArrayList<Candidate> candidates) {
        CadidateDAO.Instance().searchCandidate(candidates);
    }
    
    
}
