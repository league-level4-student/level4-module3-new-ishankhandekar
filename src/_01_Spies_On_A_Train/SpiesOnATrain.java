package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	String spy = "";
    	ArrayList<String> QuestionedPassengers = new ArrayList<String>();
    	ArrayList<String> PeopleDoingClue1 = new ArrayList<String>();
    	ArrayList<String> PeopleDoingClue2 = new ArrayList<String>();
    	ArrayList<String> PeopleDoingClue3 = new ArrayList<String>();
    	ArrayList<String> clue = new ArrayList<String>();
    	ArrayList<String> name = new ArrayList<String>();
    	Node<TrainCar> n1 = train.getHead();
    	while (n1 != null) {
			QuestionedPassengers.add(n1.getValue().questionPassenger());
			n1 = n1.getNext();
		}
    	for (int i = 0; i < QuestionedPassengers.size(); i++) {
    		clue.add(QuestionedPassengers.get(i).substring(QuestionedPassengers.get(i).lastIndexOf("I saw ") + 6, 
    				QuestionedPassengers.get(i).length()-1)) ;
			
			int spaceIdx = clue.get(i).indexOf(" ") + 1;
			 name.add(clue.get(i).substring(0,spaceIdx));
			
			 clue.set(i, clue.get(i).substring(spaceIdx));
			
		}
    for (int i = 0; i < 3; i++) {
    	for (int j = 0; j < clue.size(); j++) {
			if (clue.get(j).equals(clues[i])) {
				if (i == 0) {
					PeopleDoingClue1.add(name.get(j));
				}else if (i == 1) {
					PeopleDoingClue2.add(name.get(j));
				}else {
					PeopleDoingClue3.add(name.get(j));
				}
			}
		}
	}
   
    PeopleDoingClue1.retainAll(PeopleDoingClue2);
    PeopleDoingClue1.retainAll(PeopleDoingClue3);
    	System.out.println(PeopleDoingClue1);
        return PeopleDoingClue1.get(0).trim();

    }

}
