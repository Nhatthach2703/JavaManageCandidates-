/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAcess.CandidateDAO;
import Model.Candidate;
import java.util.ArrayList;

/**
 *
 * @author Xuan Vinh
 */
public class CandidateRepository implements ICandidateRepository{
    private ArrayList<Candidate> candidates;

    public CandidateRepository() {
        candidates = new ArrayList();
    }

    @Override
    public void createNewCandidate(ArrayList<Candidate> candidates, int type) {
        CandidateDAO.Instance().createNewCandidate(candidates, type);
    }

    @Override
    public void searchCandidate(ArrayList<Candidate> candidates) {
        CandidateDAO.Instance().searchCandidate(candidates);
    }
    
    
}
