
package org.launchcode.techjobs_oo;
import java.util.Objects;


public class Job {
    private Integer id;
    private static Integer nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId().equals(job.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Employer getEmployer() { return employer; }
    public void setEmployer(Employer employer) { this.employer = employer; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public PositionType getPositionType() { return positionType; }
    public void setPositionType(PositionType positionType) { this.positionType = positionType; }
    public CoreCompetency getCoreCompetency() { return coreCompetency; }
    public void setCoreCompetency(CoreCompetency coreCompetency) {this.coreCompetency = coreCompetency; }

    @Override
    public String toString() {
        String noData = "Data not available";
        String toStringName;
        String toStringEmployer;
        String toStringLocation;
        String toStringPositionType;
        String toStringCoreCompetency;

        if(getName()==null && getLocation()==null && getPositionType()==null && getCoreCompetency()==null) {
            return "OOPS! This job does not seem to exist";
        }

        if(getName() == null || getName().isEmpty()) {toStringName = noData;} else {toStringName = getName();};
        if(getEmployer() == null || getEmployer().getValue().isEmpty()) {toStringEmployer = noData;} else {toStringEmployer = getEmployer().toString();};
        if(getLocation() == null || getLocation().getValue().isEmpty()) {toStringLocation = noData;} else {toStringLocation = getLocation().toString();};
        if(getPositionType() == null || getPositionType().getValue().isEmpty()) {toStringPositionType = noData;} else {toStringPositionType =
                getPositionType().toString();};
        if(getCoreCompetency() == null || getCoreCompetency().getValue().isEmpty()) {toStringCoreCompetency = noData;} else {toStringCoreCompetency =
                getCoreCompetency().toString(); };

        return "\n" + "ID: " + getId() + "\n" + "Name: " + toStringName + "\n" + "Employer: " + toStringEmployer + "\n" + "Location: " + toStringLocation + "\n" + "Position Type: " + toStringPositionType + "\n" + "Core Competency: " + toStringCoreCompetency + "\n";
    }
}