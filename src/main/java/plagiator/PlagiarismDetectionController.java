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
    public Similarity greeting(@RequestParam(value="template1", defaultValue="") String template1,
                             @RequestParam(value="template2", defaultValue="") String template2) {
        System.out.println("template1: " + template1);
        System.out.println("template2: " + template2);
//        if (Utils.checkSimilarityBasic(template1, template2)) {
//            return new Similarity(100, 100);
//        }
        float wagnerFischer = new WagnerFischer().apply(template1, template2);
        float jaccard = new JaccardSimilarity().apply(template1, template2);

        return new Similarity(jaccard, wagnerFischer);
    }
}
