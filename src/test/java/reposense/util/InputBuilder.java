package reposense.util;

import java.nio.file.Path;
import java.nio.file.Paths;

import reposense.parser.ArgsParser;

/**
 * A utility class to help with building command line input.
 * Example usage: <br>
 * {@code String input = new InputBuilder().addSinceDate("27/01/2017").build();}
 */
public class InputBuilder {
    private static final String WHITESPACE = " ";

    private StringBuilder input;
    private boolean shallowCloning;

    public InputBuilder() {
        init();
    }

    /**
     * Initialize variables to default values.
     * Used by {@link InputBuilder#InputBuilder() constructor} and {@link InputBuilder#reset() reset} method.
     */
    private void init() {
        input = new StringBuilder();
        shallowCloning = false;
    }

    /**
     * Returns the {@code input} generated from this {@link InputBuilder}.
     */
    public String build() {
        return input.toString();
    }

    /**
     * Add a help flag to the input.
     * This method should only be called once in one build.
     */
    public InputBuilder addHelp() {
        input.append(ArgsParser.HELP_FLAGS[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds the config flag with the {@code path} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param path The config folder path.
     */
    public InputBuilder addConfig(Path path) {
        input.append(ArgsParser.CONFIG_FLAGS[0] + WHITESPACE + addQuotationMarksToPath(path) + WHITESPACE);
        return this;
    }

    /**
     * Adds the repo flag with the {@code paths} as arguments to the input.
     * This method should only be called once in one build.
     *
     * @param paths The repo paths.
     */
    public InputBuilder addRepos(String... paths) {
        input.append(ArgsParser.REPO_FLAGS[0] + WHITESPACE);
        for (String path : paths) {
            input.append(addQuotationMarksToPath(path) + WHITESPACE);
        }
        return this;
    }

    /**
     * Adds the view flag with the {@code path} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param path The view folder path.
     */
    public InputBuilder addView(Path path) {
        input.append(ArgsParser.VIEW_FLAGS[0] + WHITESPACE + addQuotationMarksToPath(path) + WHITESPACE);
        return this;
    }

    /**
     * Adds the view flag only to the input.
     * This method should only be called once in one build.
     */
    public InputBuilder addView() {
        input.append(ArgsParser.VIEW_FLAGS[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds the output flag with the {@code path} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param path The output folder path (type {@link Path}).
     */
    public InputBuilder addOutput(Path path) {
        input.append(ArgsParser.OUTPUT_FLAGS[0] + WHITESPACE + addQuotationMarksToPath(path) + WHITESPACE);
        return this;
    }

    /**
     * Adds the output flag with the {@code path} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param path The output folder path (type {@link String}).
     */
    public InputBuilder addOutput(String path) {
        return addOutput(Paths.get(path));
    }

    /**
     * Adds the since flag with the {@code date} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param date The since date.
     */
    public InputBuilder addSinceDate(String date) {
        input.append(ArgsParser.SINCE_FLAGS[0] + WHITESPACE + date + WHITESPACE);
        return this;
    }

    /**
     * Adds the until flag with the {@code date} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param date The until date.
     */
    public InputBuilder addUntilDate(String date) {
        input.append(ArgsParser.UNTIL_FLAGS[0] + WHITESPACE + date + WHITESPACE);
        return this;
    }

    /**
     * Adds the period flag with the {@code period} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param period The period.
     */
    public InputBuilder addPeriod(String period) {
        input.append(ArgsParser.PERIOD_FLAGS[0] + WHITESPACE + period + WHITESPACE);
        return this;
    }

    /**
     * Adds the format flag with the {@code formats} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param formats The formats that need to be evaluated.
     */
    public InputBuilder addFormats(String formats) {
        input.append(ArgsParser.FORMAT_FLAGS[0] + WHITESPACE + formats + WHITESPACE);
        return this;
    }

    /**
     * Adds the ignoreStandaloneConfig flag to the input.
     * This method should only be called once in one build.
     */
    public InputBuilder addIgnoreStandaloneConfig() {
        input.append(ArgsParser.IGNORE_CONFIG_FLAGS[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds the ignoreFilesizeLimit flag to the input.
     * This method should only be called once in one build.
     */
    public InputBuilder addIgnoreFilesizeLimit() {
        input.append(ArgsParser.IGNORE_SIZELIMIT_FLAGS[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds the timezone flag with the {@code zoneId} as argument to the input.
     * This method should only be called once in one build.
     */
    public InputBuilder addTimezone(String zoneId) {
        input.append(ArgsParser.TIMEZONE_FLAGS[0] + WHITESPACE + zoneId + WHITESPACE);
        return this;
    }

    /**
     * Adds the cloning threads flag with the {@code threads} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param threads The number of threads for cloning.
     */
    public InputBuilder addNumCloningThreads(int threads) {
        input.append(ArgsParser.CLONING_THREADS_FLAG[0] + WHITESPACE + threads + WHITESPACE);
        return this;
    }

    /**
     * Adds the analysis threads flag with the {@code threads} as argument to the input.
     * This method should only be called once in one build.
     *
     * @param threads The number of threads for analysis.
     */
    public InputBuilder addNumAnalysisThreads(int threads) {
        input.append(ArgsParser.ANALYSIS_THREADS_FLAG[0] + WHITESPACE + threads + WHITESPACE);
        return this;
    }

    /**
     * Adds the flag to enable shallow cloning.
     * This method should only be called once in one build.
     */
    public InputBuilder addShallowCloning() {
        input.append(ArgsParser.SHALLOW_CLONING_FLAGS[0] + WHITESPACE);
        shallowCloning = true;
        return this;
    }

    /**
     * Adds the flag to enable find previous authors.
     * This method should only be called once in one build.
     */
    public InputBuilder addFindPreviousAuthors() {
        input.append(ArgsParser.FIND_PREVIOUS_AUTHORS_FLAGS[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds the flag to include modified date in lines.
     * This method should only be called once in one build.
     */
    public InputBuilder addLastModifiedDateFlags() {
        input.append(ArgsParser.LAST_MODIFIED_DATE_FLAGS[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds the flag to enable fresh cloning.
     * This method should only be called once in one build.
     */
    public InputBuilder addFreshCloning() {
        input.append(ArgsParser.FRESH_CLONING_FLAG[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds the flag to enable authorship analysis.
     * This method should only be called once in one build.
     */
    public InputBuilder addAnalyzeAuthorship() {
        input.append(ArgsParser.ANALYZE_AUTHORSHIP_FLAGS[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds the flag to enable originality threshold.
     * This method should only be called once in one build.
     */
    public InputBuilder addOriginalityThreshold(double threshold) {
        input.append(ArgsParser.ORIGINALITY_THRESHOLD_FLAGS[0] + WHITESPACE + threshold + WHITESPACE);
        return this;
    }

    /**
     * Adds the flag to enable code portfolio optimized view.
     * This method should only be called once in one build.
     */
    public InputBuilder addPortfolio() {
        input.append(ArgsParser.PORTFOLIO_FLAG[0] + WHITESPACE);
        return this;
    }

    public InputBuilder addOnlyTextRefreshed() {
        input.append(ArgsParser.REFRESH_ONLY_TEXT_FLAG[0] + WHITESPACE);
        return this;
    }

    /**
     * Adds {@code content} to the input.
     */
    public InputBuilder add(String content) {
        input.append(content + WHITESPACE);
        return this;
    }

    /**
     * Adds {@code num} of white spaces to the input.
     *
     * @param num The number of white spaces to add.
     */
    public InputBuilder addWhiteSpace(int num) {
        for (int i = 0; i < num; i++) {
            input.append(WHITESPACE);
        }
        return this;
    }

    /**
     * Clears all input and flags given.
     */
    public InputBuilder reset() {
        init();
        return this;
    }

    private static String addQuotationMarksToPath(String path) {
        return '"' + path + '"';
    }

    private static String addQuotationMarksToPath(Path path) {
        return addQuotationMarksToPath(path.toString());
    }

    public boolean isShallowCloning() {
        return shallowCloning;
    }
}
