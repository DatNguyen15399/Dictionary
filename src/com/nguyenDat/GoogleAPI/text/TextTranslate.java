

package gtranslate.text;

public class TextTranslate {
    private gtranslate.text.Text input;
    private gtranslate.text.Text output;

    public TextTranslate(gtranslate.text.Text input, String loutput) {
        this.input = input;
        this.output = new gtranslate.text.Text(loutput);
    }

    public TextTranslate(gtranslate.text.Text input, gtranslate.text.Text output) {
        this.input = input;
        this.output = output;
    }

    public gtranslate.text.Text getInput() {
        return this.input;
    }

    public gtranslate.text.Text getOutput() {
        return this.output;
    }
}
