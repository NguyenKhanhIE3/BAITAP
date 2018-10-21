/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;


public class Word {
    private String spelling;
    private String explain;
    private int id;
    
    public Word(int i,String s,String e){
        this.spelling = s;
        this.explain = e;
        this.id = i;
    }
    public Word(){
        this.spelling = "";
        this.explain = "";
        this.id = 0;
    }
    
    public void setWord(int i,String s,String e) {
        this.spelling =s;
        this.explain= e;
        this.id = i;
    }
    public void setSpelling(String s) {
        this.spelling = s;
    }
    public String getSpelling() {
        return spelling;
    }

    public void setExplain(String e) {
        this.explain = e;
    }
    public String getExplain() {
        return explain;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
