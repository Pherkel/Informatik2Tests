package submission;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static submission.SampleIO.readSampleFile;

class SampleIOTest {

    @Test
    void readSampleFile_test() throws FileNotFoundException {
        short[] in = readSampleFile("../data/samples.000");
        SampleIO.writeSampleFile("writing_test", in);


    }

    @Test
    void writeSampleFile() {
    }
}