package ts;

public interface Diary_interface{
	void doCommandList();
	
	void doCommandAdd();

	void doCommandDetail(int id);

	void doCommandDelete(int id);

	void doCommandModify(int id);
}
