package com.ozayduman.customer.repository;

import com.ozayduman.customer.entity.Customer;
import com.ozayduman.customer.entity.Phone;
import com.ozayduman.customer.entity.PhoneType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class DataInitializerImpl implements DataInitializer {

    private final InitializerRepository initializerRepository;

    public DataInitializerImpl(InitializerRepository initializerRepository) {
        this.initializerRepository = initializerRepository;
    }

    private Customer create(String name, String surname, String email, String birdDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
        return new Customer(name,surname,email,LocalDate.parse(birdDate,formatter));
    }

    @Override
    public void saveSampleData(){
        initializerRepository.saveAll(createSampleData());
    }

    private List<Customer> createSampleData(){
        final var customerWithPhones = new Customer("özay", "duman", "od@gmail.com", LocalDate.of(1900,01,01));
        final var phoneBusiness = Phone.builder()
                .number("5555")
                .phoneType(PhoneType.BUSINESS)
                .build();
        final var phoneHome = Phone.builder()
                .number("55555")
                .phoneType(PhoneType.HOME)
                .build();
        customerWithPhones.addPhone(phoneBusiness);
        customerWithPhones.addPhone(phoneHome);

        return List.of(
                customerWithPhones,
                create("Doloritas", "Yewdell", "dyewdell3@earthlink.net", "1991/06/11"),
                create("April", "Cargill", "acargill4@i2i.jp", "2020/08/10"),
                create("Ermina", "Chisnell", "echisnell5@ycombinator.com", "2007/08/13"),
                create("Dominik", "Gyngyll", "dgyngyll6@wix.com", "1991/08/23"),
                create("Marcy", "Schwaiger", "mschwaiger7@diigo.com", "1994/04/14"),
                create("Abbey", "Muddicliffe", "amuddicliffe8@wufoo.com", "2005/06/19"),
                create("Ebony", "Richardeau", "erichardeau9@bluehost.com", "2004/11/15"),
                create("Falkner", "McBay", "fmcbaya@mozilla.org", "1986/03/30"),
                create("Farra", "Tatnell", "ftatnellb@symantec.com", "2001/02/24"),
                create("Filippa", "Willows", "fwillowsc@sbwire.com", "1988/09/20"),
                create("Marietta", "Trowsdale", "mtrowsdaled@mayoclinic.com", "2004/05/04"),
                create("Iggy", "Yanson", "iyansone@forbes.com", "1987/03/23"),
                create("Margy", "Bechley", "mbechleyf@nifty.com", "1986/05/26"),
                create("Norman", "Gresch", "ngreschg@parallels.com", "2008/10/19"),
                create("Tamiko", "MacManus", "tmacmanush@ask.com", "1993/09/15"),
                create("Hillie", "Conklin", "hconklini@google.com.br", "2013/02/18"),
                create("Loren", "Neaverson", "lneaversonj@woothemes.com", "1994/05/05"),
                create("Cammie", "Perago", "cperagok@gravatar.com", "2012/04/07"),
                create("Salim", "Ganing", "sganingl@infoseek.co.jp", "1998/03/17"),
                create("Kass", "Coltherd", "kcoltherdm@techcrunch.com", "1996/11/26"),
                create("Carla", "Lutas", "clutasn@usnews.com", "2001/10/03"),
                create("Standford", "Badwick", "sbadwicko@rediff.com", "2011/01/07"),
                create("Lorne", "Mewis", "lmewisp@alexa.com", "1993/10/15"),
                create("Ric", "Quaife", "rquaifeq@dot.gov", "2019/05/15"),
                create("Paulina", "Benjafield", "pbenjafieldr@wiley.com", "2006/12/04"),
                create("Grant", "Bahl", "gbahls@hatena.ne.jp", "2001/12/09"),
                create("Julieta", "Greenroyd", "jgreenroydt@deviantart.com", "1997/03/11"),
                create("Freemon", "Roth", "frothu@mayoclinic.com", "2013/06/10"),
                create("Alice", "Bentz", "abentzv@icq.com", "2008/08/05"),
                create("Ruthanne", "Haking", "rhakingw@telegraph.co.uk", "2011/03/22"),
                create("Cedric", "Antoniutti", "cantoniuttix@nasa.gov", "2002/01/26"),
                create("Sydney", "Maddison", "smaddisony@bloomberg.com", "1999/10/10"),
                create("Elsy", "McClymont", "emcclymontz@google.it", "2005/08/30"),
                create("Marshal", "Ripping", "mripping10@wsj.com", "1992/07/25"),
                create("Luce", "Sparrow", "lsparrow11@usa.gov", "1990/07/25"),
                create("Blinny", "Lusk", "blusk12@squidoo.com", "1994/10/07"),
                create("Towny", "Burdass", "tburdass13@blogtalkradio.com", "2013/01/29"),
                create("Lise", "Rabat", "lrabat14@sphinn.com", "1993/02/24"),
                create("Gerome", "Ashbe", "gashbe15@goodreads.com", "2008/08/16"),
                create("Selma", "Epinoy", "sepinoy16@icq.com", "1999/06/22"),
                create("Kyrstin", "Lathe", "klathe17@whitehouse.gov", "2014/01/24"),
                create("Rodi", "Starking", "rstarking18@telegraph.co.uk", "2015/08/12"),
                create("Nathaniel", "Ffrench", "nffrench19@ibm.com", "1991/09/05"),
                create("Marion", "Usherwood", "musherwood1a@51.la", "1999/05/28"),
                create("Sarita", "Rohlfs", "srohlfs1b@washingtonpost.com", "1990/08/07"),
                create("Garvin", "Barnsdale", "gbarnsdale1c@yellowpages.com", "1998/09/05"),
                create("Kirsti", "Freschi", "kfreschi1d@rambler.ru", "1992/09/15"),
                create("Trey", "Romer", "tromer1e@infoseek.co.jp", "2010/11/14"),
                create("Sutton", "Greest", "sgreest1f@scientificamerican.com", "2004/10/14"),
                create("Steffie", "Thor", "sthor1g@opensource.org", "2000/10/13"),
                create("Loleta", "Oag", "loag1h@discovery.com", "1991/06/18"),
                create("Chanda", "Horney", "chorney1i@columbia.edu", "1986/10/12"),
                create("Tory", "Bridges", "tbridges1j@moonfruit.com", "2001/12/05"),
                create("Tabb", "Kibby", "tkibby1k@slideshare.net", "2020/05/13"),
                create("Rozanne", "Schneidau", "rschneidau1l@pen.io", "2014/08/13"),
                create("Dorie", "Trillow", "dtrillow1m@archive.org", "2006/07/09"),
                create("Carmon", "Mechell", "cmechell1n@noaa.gov", "2019/03/16"),
                create("Leeann", "Tomczykiewicz", "ltomczykiewicz1o@stumbleupon.com", "2004/10/27"),
                create("Herb", "Daelman", "hdaelman1p@taobao.com", "1991/11/29"),
                create("Randee", "Kuhnhardt", "rkuhnhardt1q@topsy.com", "2002/09/09"),
                create("Karmen", "Duplan", "kduplan1r@1und1.de", "2015/12/20"),
                create("Salli", "Chipp", "schipp1s@macromedia.com", "2003/04/03"),
                create("Greer", "Connock", "gconnock1t@discovery.com", "2018/01/26"),
                create("Seamus", "Scurr", "sscurr1u@mapy.cz", "2013/06/02"),
                create("Vanessa", "Moukes", "vmoukes1v@hugedomains.com", "2007/03/23"),
                create("Meier", "McIlherran", "mmcilherran1w@webs.com", "1988/10/06"),
                create("Tripp", "Tenbrug", "ttenbrug1x@networksolutions.com", "2009/06/07"),
                create("Karna", "Van", "kvan1y@mit.edu", "2020/05/14"),
                create("Ira", "Tulloch", "itulloch1z@cisco.com", "2002/02/10"),
                create("Tracy", "Giannazzi", "tgiannazzi20@ibm.com", "1987/08/19"),
                create("Jecho", "Kennler", "jkennler21@weebly.com", "2019/09/02"),
                create("Coleen", "Greenall", "cgreenall22@census.gov", "2005/06/20")
        );

    }
}
