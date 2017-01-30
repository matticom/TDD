package customer;

public interface IPrinter {
	public void print(String line) throws OutOfPaperException;
	public void tab() throws OutOfPaperException;
	public void crlf() throws OutOfPaperException;
	public void cutPaper() throws OutOfPaperException;
}
