package xspeedltspringboot.demo.xspeedltspingboot.demo.restful.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import xspeedltspringboot.demo.xspeedltspringboot.demo.model.Box;
import xspeedltspringboot.demo.xspeedltspringboot.demo.model.ArticlesInBoxes;

@RestController
@RequestMapping(value = "/api/articles")
public class ArticlesController {

    ArticlesInBoxes aIB = new ArticlesInBoxes();

    @RequestMapping(method = RequestMethod.GET)
    public Box getArticlerangé() {
        String val = aIB.boxes;
        Box boites = new Box(val);
        aIB.boxes="";
        return boites;
    }


    @RequestMapping(method = RequestMethod.POST)
    public void getArticles(@RequestBody Box article) {
        aIB.setArticlesInBoxes(article);
        }
    }

