package GameCode;

import collections.LinkedList;
import tools.Sort;

/**
 * Updater.java - description
 *
 * @author Ethan Alexander
 * @since Mar. 17, 2021,10:59:21 a.m.
 */
//public class Updater <T> {
public class Updater {

    private static int scoreBoardSize = 10;

    /**
     * Default constructor for class, sets class properties
     */
    public void Updater(){
        setScoreBoardeSize(scoreBoardSize);
        
    }
    
    /**
     * adds the number score that the player got to the highscore board.
     * the number is added then the tail of the list is removed 
     * 
     * @param oldList the old list of highscores
     * @param number the new score 
     * @return the new highscore list
     */
    public LinkedList<Integer> add(LinkedList<Integer> oldList, Integer number) {
        LinkedList<Integer> newList = new LinkedList<>();
        newList = oldList.clone();
        newList.add(number);
        Sort sort = new Sort();
        sort.bubble(newList);        
        if (newList.size() > scoreBoardSize) {
            newList.removeBack();
        }
        return newList;
    }

    /**
     * outputs the highscore list as a string 
     * 
     * @param list the list to output
     * @param newNumber the new score 
     */
    public String output(LinkedList<Integer> list, Integer newNumber) {
        String text = "Highscores: \n";
        for (int i = 0; i < scoreBoardSize; i++) {
            if (newNumber != list.get(i)) {
                text += (i + 1) + ". " + list.get(i) + "\n";
            } else {
                text += (i + 1) + ". " + list.get(i) + " <-\n"; 
            }
        }
        text += "\nYour Score -> " + newNumber;
        System.out.println(text);
        return text;
    }

    /**
     * gets the size of the scoreboard
     * 
     * @return the size of the scoreboard
     */
    public int getScoreBoardSize() {
        return scoreBoardSize;
    }

    /**
     * sets the size of the scoreboard
     * 
     * @param newSize 
     */
    private void setScoreBoardeSize(int newSize) {
        int oldSize = scoreBoardSize;
        scoreBoardSize = newSize;
        System.out.println("Scoreboard(size) " + oldSize + " --> " + newSize);
    }
}
