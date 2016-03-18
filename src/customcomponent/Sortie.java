/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcomponent;

public class Sortie
{
    public int val,ID;
    public String caption;

    public Sortie(String caption, int val, int ID)
    {
        this.ID = ID;
        this.val = val;
        this.caption = caption;
    }
    public String toString()
    {
        return new String(caption+" ("+val+")");
    }
}