package metier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class MetierProduitImpl implements IMetier<Produit> {
    List<Produit> produits = new ArrayList<>();


    @Override
    public void add(Produit o) {
        Produit prod = new Produit();
        for (Produit p : produits) {
            if (p.getId() == o.getId()) {
                System.err.println("produit deja exist");

            } else
                prod = p;

        }
        produits.add(o);
    }


    @Override
    public List<Produit> getAll() {
        return this.produits;
    }

    @Override
    public Produit findById(long id) {
        Produit P=new Produit();
        for (Produit p:produits ){
            if(p.getId()==id){
                P=p;
            }
        }
        return P;
    }

    @Override
    public void delete(long id) {
        Produit p = new Produit();
        for (Produit produit : produits) {
            if (produit.getId() == id) ;
            p = produit;
        }
        produits.remove(p);
    }

    @Override
    public void SaveAll() throws IOException {
        File f1 = new File("produits.dat");
        FileOutputStream Fos = new FileOutputStream(f1);
        ObjectOutputStream Oos = new ObjectOutputStream(Fos);
        for (Produit p : produits) {
            Oos.writeObject(p + "\n");
        }
        System.out.println("successful");
        Fos.close();
        Oos.close();
    }
}
