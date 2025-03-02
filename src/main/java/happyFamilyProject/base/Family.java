package happyFamilyProject.base;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(){}

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    public Family(Human mother, Human father, List<Human> children, Set<Pet> pets) {
        this(mother, father);
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
    }

    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public List<Human> getChildren() { return children; }
    public Set<Pet> getPets() { return pets; }

    public void addChild(Human child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
        setPets();
    }
    public void setPets() {
        if (pets == null) {
            pets = new HashSet<>();
        }
        pets.clear();

        if (mother != null && mother.getPet() != null) pets.add(mother.getPet());
        if (father != null && father.getPet() != null) pets.add(father.getPet());

        if (children == null) {
            children = new ArrayList<>();
        }
        for (Human child : children) {
            if (child.getPet() != null) pets.add(child.getPet());
        }
    }

    public boolean deleteChild(Human child) { return children.remove(child); }

    public boolean deleteChild(int index) {
        if (children == null || index < 0 || index >= children.size()) {
            return false;
        }
        children.remove(index);
        return true;
    }
    public int countFamily() { return 2 + (children != null ? children.size() : 0); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.equals(children, family.children) &&
                Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }

    @Override
    public String toString() {
        return """
        Family{
            mother: %s,
            father: %s,
            children: %s,
            pets: %s
        }
        """.formatted(
                (mother != null ? mother.toString() : "unknown"),
                (father != null ? father.toString() : "unknown"),
                (children.isEmpty() ? "none" : children.toString()),
                (pets.isEmpty() ? "no pets" : pets)
        );
    }
}