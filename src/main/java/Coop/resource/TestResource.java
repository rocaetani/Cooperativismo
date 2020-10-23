package Coop.resource;

import Coop.domain.Associate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/Test")
public class TestResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Associate> getHello(){
        Associate associate = new Associate("1","000.000.000-00");
        List<Associate> list = new ArrayList<Associate>();
        list.add(associate);
        return list;
    }

}
