import com.crjj.ismo.entities.DAO.IDao;
import com.crjj.ismo.entities.DAO.TypeDao;

import java.util.List;
import java.util.Scanner;

import com.crjj.ismo.entities.Appartement;
import com.crjj.ismo.entities.Etage;
import com.crjj.ismo.entities.Immeuble;
import com.crjj.ismo.entities.Rue;
import com.crjj.ismo.entities.DAO.DaoAppartement;
import com.crjj.ismo.entities.DAO.DaoEtage;
import com.crjj.ismo.entities.DAO.DaoFactory;
import com.crjj.ismo.entities.DAO.DaoImmeuble;
import com.crjj.ismo.entities.DAO.DaoRue;

public class Principale {
	
public static void displayImmeubles(List<Immeuble> i) {
		
		i.stream().forEach(item -> System.out.println(item));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i= 0;
		   Scanner rs =new Scanner(System.in);
		   while(i != 0) {
			   System.out.println("0- Quitter");
			   System.out.println("1- Afficher toutes les immeubles:");
			   System.out.println("2- Afficher toutes les immeubles d'une rue donnée par l'utilisateur ");
			   System.out.println("3- Supprimer un appartement par id");
			   System.out.println("4- Modifier un Etage");
			   i = rs.nextInt();
			   switch (i) {
			case 0:
				System.out.println("Fin Programme");
				break;
			case 1:
				DaoImmeuble daoImm= (DaoImmeuble) DaoFactory.getDAO(TypeDao.Immeuble);
				for(Immeuble im : daoImm.getAll())
					System.out.println(im);
				break;
			case 2:
				System.out.println("Tapez l'id de la rue pour afficher les immeubles");
				int id=rs.nextInt();
				DaoRue doaRue= (DaoRue) DaoFactory.getDAO(TypeDao.Rue);
				Rue rue = doaRue.getOne(id);
				for(Immeuble im : rue.getImmeubles())
					System.out.println(im);
				break;
			case 3:
				System.out.println("Tapez l'id de l'Appartement");
				String ids  = rs.next();
				DaoAppartement daoApp= (DaoAppartement) DaoFactory.getDAO(TypeDao.Appartement);
				Appartement app=new Appartement("A",4,1);
				if(daoApp.delete(app))
					System.out.println("Suppression effectuée avec succèss");
				else
					System.out.println("Supression échouée");
				break;
			case 4:
				System.out.println("Tapez l'id de l'étage");
				id  = rs.nextInt();
				DaoEtage daoEtage= (DaoEtage) DaoFactory.getDAO(TypeDao.Etage);
				
				System.out.println("Tapez un n° d'Appartement");
				int  nbApp = rs.nextInt();
				Etage et=new Etage(0,nbApp,2);
				if(daoEtage.update(et))
					System.out.println("Modification avec succèss");
				else
					System.out.println("Modification échouée");
				break;

			default:
				break;
			}
		
	}

}
