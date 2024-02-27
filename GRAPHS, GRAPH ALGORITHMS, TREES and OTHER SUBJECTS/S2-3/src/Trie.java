import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
class Trie{
    public static void main(String args[]) {

        read();

        try {

            Scanner s = new Scanner(new File("words.txt"));  // dışardan veri listesi almak için

            Trie t = new Trie();

            while(s.hasNextLine()) {
                t.add(s.nextLine());
            }


            System.out.println(t.find("KodSözlük"));  // trie'de veri arama işlemi

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    static void read() {

    }


    Node root;

    Trie(){
        root = new Node();
    }

    void add(String word) {

        Node tmp = root;

        for(int i=0;i<word.length();i++) {

            char character = word.charAt(i);

            if(tmp.children[(int)character] == null) {
                tmp.children[(int)character] = new Node();
            }

            tmp = tmp.children[(int)character];

        }

        tmp.end = true;

    }

    boolean find(String word) {

        Node tmp = root;

        for(int i=0;i<word.length();i++) {

            char character = word.charAt(i);

            if(tmp.children[(int)character] != null) {

                tmp = tmp.children[(int)character];

            }else {
                return false;
            }
        }

        if(tmp != null && tmp.end)
            return true;

        return false;
    }

}

class Node{

    Node children[] = new Node[256];
    boolean end;

    Node(){
        end = false;
        for(int i=0;i<children.length;i++)
            children[i] = null;
    }
}
