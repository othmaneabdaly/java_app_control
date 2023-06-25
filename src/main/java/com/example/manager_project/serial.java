package com.example.manager_project;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class serial {
    File fichier ;

    public serial(File fichier) {
        this.fichier = fichier;
    }
    public void write(Manager m) throws IOException {
        Manager nj;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        boolean flag = false;
        File tmp = new File("tmp.txt");
        out = new ObjectOutputStream(new FileOutputStream(tmp));
        try {
            in = new ObjectInputStream(new FileInputStream(fichier));
            nj = (Manager) in.readObject();
            while(nj!=null){
                if (m.ManagerID.equals(nj.ManagerID)) {
                    out.writeObject(m);
                    flag = true;

                }else{
                    out.writeObject(nj);
                }
                nj = (Manager) in.readObject();
            }
        }catch (FileNotFoundException e){}
        catch (ClassNotFoundException e) {}
        catch (EOFException e){
            in.close();
        }
        if(!flag ){
            out.writeObject(m);


        }
        out.close();
        fichier.delete();
        tmp.renameTo(fichier);


    }
    Set<Manager> read() throws  IOException{
        Manager nj;
        Set<Manager>s= new HashSet<Manager>();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichier));
        try{
            nj = (Manager) in.readObject();
            while(nj!=null){
                s.add(nj);
                nj = (Manager) in.readObject();
            }
        }catch(EOFException e){
            in.close();
        }catch (ClassNotFoundException e){

        }
        return s;
    }
}
