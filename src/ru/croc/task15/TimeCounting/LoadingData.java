package ru.croc.task15.TimeCounting;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class LoadingData {
    private static Path filePath;

    public static void loadingData(String path, ArrayList<Organization> data) throws IOException {
        filePath = Paths.get(path);
        List<String> helpList = Files.readAllLines(filePath);
        for (String s : helpList) {
            String[] helpMassive = s.split(",");
            //System.out.println(Arrays.toString(helpMassive));
            // после сплита получаем <код родительского отдела или “-”, если отдел корневой>, <время обработки заявки в часах>
            ArrayList<Organization> children = new ArrayList<>();
            Organization current = new Organization(Integer.parseInt(helpMassive[2]), helpMassive[0], helpMassive[1], children);
            if (helpMassive[1].equals("-")) {
                data.add(current);
                // если отдел корневой то можно просто добавить в лист data
            } else {
                // предположим что случились неполадки в файле, и так получилось, что родительские отделы в файле идут
                // после дочерних, это означает, что дочерние не добавились в этом случае
                // во избежание таких проблем стоит пробежаться и посмотреть всех ли мы добавили в дочерние отделы отдела

                for (Organization p : data) {
                    if (p.getNameOfParent().equals(current.getName())) {
                        boolean Flag = true;
                        for (Organization m : current.childDepartments) {
                            if (m.getName().equals(p.getName())) {
                                Flag = false;
                                break;
                            }
                        }
                        if (Flag) {
                            current.childDepartments.add(p);
                            break;
                        }
                    }
                }


                // если отдел не корневой, то недостаточно просто добавить, нужно ещё добавить в лист родительского отдела
                //ищем родителя элемента
                for (Organization p : data) {
                    if (p.getName().equals(helpMassive[1])) {
                        p.childDepartments.add(current);
                        break;
                    }
                }
                data.add(current); // добавляем текущий элемент
            }
        }


    }
}
