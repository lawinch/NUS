package plagiator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plagiator.algorithms.WagnerFischer;

@RestController
public class PlagiarismDetectionController {

    @RequestMapping("/detect")
    @PostMapping
    public Similarity greeting(@RequestParam(value="template1", defaultValue="") String template1,
                             @RequestParam(value="template2", defaultValue="") String template2) {
        float similarity1 = WagnerFischer.getSimilarityScore(template1, template2);
        int similarity2 = WagnerFischer.getSimilarityScore2(template1, template2);
        return new Similarity(similarity1, (float)similarity2);
    }
}
