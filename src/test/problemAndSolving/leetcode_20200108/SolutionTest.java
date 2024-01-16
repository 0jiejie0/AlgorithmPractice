package test.problemAndSolving.leetcode_20200108;

import main.problemAndSolving.leetcode.leetcode_20200108.Solution;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void countCharacters() {
        String[] strings = new String[]{"cat", "bt", "hat", "tree"};
        String dict = "atach";
        Assert.assertEquals(6, solution.countCharacters(strings, dict));
        strings = new String[]{
                "aw", "sot", "vyei", "muui", "gyxl", "dylhds", "bxjvop", "qffrjfkj", "gmwbirxt", "xkickycwzj",
                "wduqkbncayo",
                "szgkkhuhkcnr",
                "utohzbqvkqkq",
                "jcnpsxnkbqdbh",
                "jxwouobfvzttz",
                "naktgxfyuvuoh",
                "xedhntgrqegfs",
                "bbaigjqxdmuchkkb",
                "fidqszoicndwifns",
                "xljgysrjjukphjgzbpn",
                "xoghnhpypfiibqrpgtyux",
                "kubshvnldnkofitnnjere",
                "aswdmctosieicucsjwxych",
                "zqlzxpemomnbzxlorvlkxt",
                "fcskqxwkzsldsjihahalnw",
                "yucpsdhqvzboeezcqpxsepuuk",
                "ytjuaagqnfxqwiopolnejmoxow",
                "iwbdmxdcbypnzqmgkrjhfivkrmnv",
                "cxhpbcziptgandiwxtctdjpboiqwv",
                "hpmdzhpgijirecxzkuyhptiytnuscu",
                "xjmkcsekcorldyrjiavrhuhqtndujymc",
                "mlegvhxielwlfadlnqvnipcuizpdxgtvro",
                "ozihktgnvljzhqwanxemtzxphzqvmoblvi",
                "gmybflbjunudxrwguzditaxmyadgdjeengut",
                "ghzqskipqprrzeligdjyowypeerogxonvztsq",
                "mtddspmqwbnoiajpexsuhxogarduzsoammqqelh",
                "lsstgzxjxabcbspjwelqmhtnurgfmdtpaihxnxad",
                "qmhwlymfsjixvvjhkczylqcsnbjxliasetxciggtfl",
                "oqoskpzkwxsffgeuuhdklidtmjobzayatyaqefgwgqbo",
                "ykmsksjorovmdymlbgprvprnyxwppvwgmzfjsqouvgara",
                "nwrwtwetgjwooevhxhkzlvsyghtkldioyjhkkniepktqs",
                "onosezgutawtzteoagbftclsqpfsxtwetourxjxurdqevrir",
                "jlnxshfthqgzlnvjzztrnjswwsotpybxecyqhnfkbfwvmxpcs",
                "zfiredtxenzgtrkiamuoubetexzbnwkdtxbtihhtsfubnmryxq",
                "lpqklgcwdvgbghfyoyejnpexrelywqfdtczflwetbxvzigtvisi",
                "lxbtlhnrfyaznrqgxrltmxkjmhdqjjgnvstxaygmuxznjfiiukm",
                "qdfkyomjlhfozonwpdxllqdnvpohyijqmyymuclnydzmlqksntdfj",
                "xviupppkeswkctwlqwyuhokbhqqjshmaeiouhununbhrkabacenkg",
                "qobxtxjzdngkrzamsxzdvbvkiwijokwdyndqllhqpaoxzwonriclsm",
                "gizysqkqbyhzeagzsscvdigtcfiupyhqovaaioxfrphugxzrcjvwqwc",
                "lhuxgqpwcgpujfvvnlrxhgbiwxmxzhglyhkdkafafojtlkuxkmjwlxrd",
                "tjsardsbhmhefysdqtbhzsxukbwdpioqaohloaancxdkkmofniojrvxj",
                "cojlyayladyrhofzetaddteqrjbyxtvyszgdorexqmgznqmuvemegbwki",
                "firxkgvkzqlnallzwjispsizoawobemuhqrhpyvknasjzwctamfuonder",
                "sixkvxgnbalipwmkbcwpugpvolsvvlmaaeeobmoeogspbkbsskwjdqkite",
                "otpcfrhckxmnseayhwoyjjfkceaoznmmkikpdsuueyqmbsuelmhqnmdsjs",
                "nsftehpgzstetbganbtozdopptseucdqkhzdmujnzjdvufqtikgeepttnrabb",
                "thholqebekkysstqzlbbdapktxumygplqganucwnahmrihiraxdnvbiaqhykcti",
                "qkhtpuhhkspffkpryvdjasbxhtfrmptpljszvtgvhfvqpxypxfdaphfqdmigzgfg",
                "kuyemuuymacyvmahtagmcewkspverpjtjscccnrczchgkjzppdxcalxxcxrwnepk",
                "goddugelwdvemxwureitzwqmbqeqtymrlrzahuxnpgufaagbpexwpoahvdnsyvgxw",
                "jbremnahqoiqktpbkteefdkbrerrxmhqbbselpnfzapgmxidrhbixetaetjcroufa",
                "wtufuqgljvxzsurhviikdxyuythezjnvwrxqrykmotkhlphlyfljjsfugzwxxfqkc",
                "zemawxwjeowraaqsqytsshtavnvoyiyollelxqabmjwhxtrdijiacbbjiiyzwkxboot",
                "ussuyjqsxwsdhkjeipwycrkcxxjatoqhygzymgikqdnqiyyzlbcdlgtmneyickucbkpkza",
                "habomjnlznqvckmowgelhnglfizogckplbymkdowfpicxydzgoskckraxpdysksvzezcpg",
                "idnaddnzbodhjrpshhahnbbnrskruxszxeeyanumazvahktizectmmvjbhnhbrohsyqhrgq",
                "xhsutriuynfrldjbhexhxjgcfwcujvwsqfiaqwvjnkjkswdpaynelhryrzfeqjhajezmolk",
                "effbptpwafzqbsebbjmvdcxdbmnlfqjklongafzkvaqmkehefedjxgxlbdhltihtgfqjjsdis",
                "rpynimubaxdgbrkdawgugnhobaowxdnzkiidworcsnejgqctftyksvbhiwkcnyffmsbxwptqn",
                "iwdsrekqllbbyarzzmbqbvldvxctdeswiyahiwfoefhfsfwktdzaulnalewbusazjhcbtxjuck",
                "fagqnapzeeglbdzsbneosxmptmwopjcxztukhpjkqjmjbkpbzrfaqskctehyboeddmilkwlurcb",
                "dfhxrctagxkuasofoejsalcerkbtsjwnbnoahsumzfyiiskhzzwyykeefszrzrbztbrzhxxgaajb",
                "fahtqqnuzhhhrcblquaosdfdcqoskxcsdnhtwvvvzsxkpjprytieieniafnltxmuzwkdnttofpibi",
                "wrssfvsbcehbahbvojnzgacbgveitirkjmmyiorwykynqddgydzgfvlvplfnyumgxturxraonpchd",
                "gvvbgpjolobpbxcnhnzuqrsqgrkanwmnnkqynakkooailoafunopsrlijqhaqmszssxikftcfoqsw",
                "oyclwdejlifmocfjsbgmernsyitkfaahjxfnwnusrdypsziawlpsjgnavytdihpxcmugshnqbkyfts",
                "ynzekkkljzrvnwclzcfgtvcmstxgadxpztofckypbgqgbnumnkeaqclaspzxjbygtkjznxeduhbksr",
                "hpgkulrmbaixnjiapmjiwhwsgromfqpxqkkiscjwpiicslwcijginxfiwqakeezeohhskxgvgdkezmqys",
                "npncdabkmbgfhnedcmbfyjiplzwymgvsfrifvvjayobsygwolqbwkblqutakcshnlsqadtfiqmpauslvqd",
                "rrcesnfbxglhjawldnnuiiepdsofbrsbjczlemusqwvenicxmtdmpwfrnizymfmqynvtkbrmablcugroshc",
                "zktqnurtpttlcjgkmnprqeyeepqunfqqvjwuevwbvnaupyofwiqwhpyumyfwpjrruhleromrmpvczlkxqiuq",
                "wtjdykncubkduhxiwwusoxvzpnaxpnzdjmwddnonsmmvwmuaxghetgrwpoeqbprxgviwzagyqopfdakrqjgiy",
                "scyzsykrwzuozmbrbenfiqpxchtpmcxepjiglaeionsmbwrzeidupayusczcooudpcgkgspbuyzcdfymsejucb",
                "bftrbaurtzkftodotjguzjmwxrrmswxwclohotuanypmhtemmsaicwckowmcdmpnhcfzptekpgljfvwpqjgilxu",
                "vibswdyqaxjvqsffwmcismooheyhwzqvyzezluejztlgddshvwcryzcllaisxrygwqyyoiaivfvgtzicycyrkckv",
                "rmxwcaorznumwxgwnibnxwzvnxjhzwqzgmkgifnnnnzpgtsvprycjtdeirtpqbduursabbidzkfbexgthkoacagkb",
                "xwcbiporfbktpvqhznjuaxfcdykifuzwdsdhxirwwxinoffywgxscrtuwhvuwjejzqirsfijgguouapqpmfdnpsfm",
                "jzjozqfqiwyfadplibubtpcfxxfvjtbizxlmpaccjpihvnrtvfqtfiaztvfbednyemfmahbljdvykddawaujdksenm",
                "yhvpsvsnhfmbmcpihnqtodspbvexnpgcqrrughbakbufyjispkquvfppkaffypdpnvikjygdaarcigipfhuvzzzbgw",
                "czxmqpowzzhdbhgtlqdokrzxowsvwyavfhcycctgdvrsfzmanrlktfaetnuayrqkvhcbxezfahkrxgaaztovrxuhnll",
                "oeqdvldvfbklukstxwomapaauaozblhxudkdxihepqagndnlkvbqhluscvczhrsrhodnftoszhjdymuywdtjgzbmkrdf",
                "vdoqnhtidgicevprrrwlbtldtaxpsxdhxhgbwlkbeglkbhrujtafswjkozdmdpvwhsuskofmxxtprtpopacslinwozth",
                "tkrsxhztwgvqxamjtexklnooaloydjhejlbasavskttwxiabarogvmfdfjttaxhgqljlbfnrvrwwbxkurhufiknoxfmemcv",
                "dlasodatffcreungntdmezgfqklrabyymsnhdberufcrgpxgsziklznhdprbczhbxgtuslufycjronozdqumzlnidkvaydg",
                "vwgmwkbturocovaykdsjaftbtgmtwknnmhexfgcfchpwwgcgecfobbencotjizxbtdrijwfjxdsxanwfjyjamrxrdaiusgr",
                "gvlwwnmrddhzwewugdtobauecealfhasyftgxkiqeluysxxmroukfziifpryvddggttojhcszeyjetbsldmorqnbuqreuxfw",
                "vbhuerxkcjlkamgruturkbrubbscmvzqruwvlrlyylcvuiothkhpznjzsfnyfoaqkziyjqzdreeygmtbdljwnaojexfgmjlup",
                "gyjosuhwgbqpcdsdqadopdqozjxpzwxbqaffnxaddhgrxmunpidvpnijxnbawshcznkmprpgkhvzxmzbaftedgtfgjhaisdnva",
                "oejzlmrrbdysqlezifcvgjnmvodfvmrnjmnfkejdbnnyljzjaxfecrfefdgarqbtwoijuktacywmsubtxtgzkbnstgrsrjpkdfe"
        };
        dict = "fcxpzkzkqeyeijquyfixvlzjpzomujrqzxeoynjiflnmdrpdkrm";
        System.out.println(strings.length);
        Assert.assertEquals(16, solution.countCharacters(strings, dict));
    }
}