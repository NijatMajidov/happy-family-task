package happyFamilyProject.dao;

import happyFamilyProject.base.Family;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    private List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return new ArrayList<>(families);
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if (families.contains(family)) {
            int index = families.indexOf(family);
            families.set(index, family);
        } else {
            families.add(family);
        }
    }
}