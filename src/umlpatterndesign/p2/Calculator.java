package umlpatterndesign.p2;

public interface Calculator {
    int classId = 0;
    double calculateArea();
    double calculateLength();
    void saveResult(String data);
    void loadResult(int dataIndex);
}
