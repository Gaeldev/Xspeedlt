package xspeedltspringboot.demo.xspeedltspringboot.demo.model;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticlesInBoxes {

    public  String boxes ="";

    public void  setArticlesInBoxes(Box box){

        //récupération des articles et mise en ArrayList
        String articlesName = box.getName();
        ArrayList<String> articlesSplite = new ArrayList<String>(Arrays.asList(articlesName.split("")));
        ArrayList<Integer>  articlesInt = new ArrayList<Integer>();
        ArrayList<String>  listeBoxesImc = new ArrayList<String>();

        //formatage des articles en int
        for (String str: articlesSplite   ) {
            articlesInt.add(Integer.parseInt(str));
        }

        int articleSize = articlesInt.size();

        ArrayList<String>  listeBoxes = new ArrayList<String>();

        //boucle permettant la formations des boites
        do{

                boolean tenOK = false;

                //cas ou il n'y aurais qu'un seul article
                if (articleSize == 1) {
                    int art1 = articlesInt.get(0);
                    listeBoxesImc.add(String.valueOf(art1));
                    articlesInt.remove(0);
                    break;

                }

                    //article qui sera testé pour être atribué à un autre
                    int art1 = articlesInt.get(0);

                    //boucle permettant d'attribué l'objet adéquat a l'article précédant
                    for (int j = 1; j < articleSize; j++) {

                        int art2 = articlesInt.get(j);

                        //test affin de vérifié qi la somme des articles est égale à 10
                        if (art1 + art2 == 10) {
                            listeBoxes.add(String.valueOf(art1) + String.valueOf(articlesInt.get(j)));
                            tenOK = true;
                        }

                        //Si le test précédent est ok alors les articles sont retiré de l'ArrayList et un article principal suivant est séléctionné
                        if (tenOK) {
                            articleSize = articleSize - 2;
                            articlesInt.remove(0);
                            art1=articlesInt.get(0);
                            j--;
                            articlesInt.remove(j);
                            break;
                        }

                    }

                    //Si aucun article ne permet d'obtenir 10 alors l'article principale est ajouté à l'ArrayList des articles seuls et un autre article pricipale est séléctionné
                    if(!tenOK){
                        listeBoxesImc.add(String.valueOf(art1));
                        articlesInt.remove(0);
                        art1=articlesInt.get(0);
                        articleSize = articleSize - 1;
                    }


        }while (articleSize != 0);

        //formation de la String de réponse des articles formant une boite de 10
        for (String str: listeBoxes  ) {
             boxes = boxes+str+"/";
        }

        //ajout des objets ne permettant pas une boite de 10
        for (String str: listeBoxesImc) {
            boxes = boxes+str+"/";
        }

        boxes = boxes.substring(0, boxes.length()-1);

    }

}
