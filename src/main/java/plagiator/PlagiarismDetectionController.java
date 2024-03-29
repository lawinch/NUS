package plagiator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plagiator.algorithms.JaccardSimilarity;
import plagiator.algorithms.WagnerFischer;

@RestController
public class PlagiarismDetectionController {

    @RequestMapping("/detect")
    @PostMapping
    public String greeting(@RequestParam(value="template1", defaultValue="") String template1,
                             @RequestParam(value="template2", defaultValue="") String template2) {
        System.out.println("template1: " + template1);
        System.out.println("template2: " + template2);
        float wagnerFischer = new WagnerFischer().apply(template1, template2);
        float jaccard = new JaccardSimilarity().apply(template1, template2);

//        Similarity sim =  new Similarity(jaccard, wagnerFischer);
        return String.format("Matching two texts: WagnerFischer Algorithm %.2f%% / %.2f%%", wagnerFischer, jaccard);

    }
}
