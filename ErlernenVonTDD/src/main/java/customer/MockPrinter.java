package customer;

import com.mockobjects.ExpectationCounter;
import com.mockobjects.ExpectationList;
import com.mockobjects.MockObject;
import com.mockobjects.util.Verifier;

class MockPrinter extends MockObject implements IPrinter {
	private ExpectationList printerOutput = new ExpectationList("printer output");
	private ExpectationCounter tabCalls = new ExpectationCounter("tab() calls");
	private ExpectationCounter crlfCalls = new ExpectationCounter("crlf() calls");
	private ExpectationCounter cutPaperCalls = new ExpectationCounter("cutPaper() calls");

	void addExpectedOutput(String output) {
		printerOutput.addExpected(output);
	}

	void setExpectedTabCalls(int numberOfCalls) {
		tabCalls.setExpected(numberOfCalls);
	}

	void setExpectedCrlfCalls(int numberOfCalls) {
		crlfCalls.setExpected(numberOfCalls);
	}

	void setExpectedCutPaperCalls(int numberOfCalls) {
		cutPaperCalls.setExpected(numberOfCalls);
	}

	public void verify() {
		Verifier.verifyObject(this);
	}

	public void print(String output) throws OutOfPaperException {
		printerOutput.addActual(output);
	}

	public void tab() throws OutOfPaperException {
		tabCalls.inc();
	}

	public void crlf() throws OutOfPaperException {
		crlfCalls.inc();
	}

	public void cutPaper() throws OutOfPaperException {
		cutPaperCalls.inc();
	}
}
