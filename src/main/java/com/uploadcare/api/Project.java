package com.uploadcare.api;

import com.uploadcare.data.ProjectData;

import java.util.ArrayList;
import java.util.List;

/**
 * The resource for project, associated with the connecting account.
 */
public class Project {

    private final Client client;
    private final ProjectData projectData;

    public Project(Client client, ProjectData projectData) {
        this.client = client;
        this.projectData = projectData;
    }

    public String getName() {
        return projectData.name;
    }

    public String getPubKey() {
        return projectData.pubKey;
    }

    public Collaborator getOwner() {
        if (projectData.collaborators.size() > 0) {
            return new Collaborator(projectData.collaborators.get(0));
        } else {
            return null;
        }
    }

    public List<Collaborator> getCollaborators() {
        ArrayList<Collaborator> collaborators = new ArrayList<Collaborator>(projectData.collaborators.size());
        for (ProjectData.CollaboratorData collaboratorData : projectData.collaborators) {
            collaborators.add(new Collaborator(collaboratorData));
        }
        return collaborators;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectData=" + projectData +
                '}';
    }

    public static class Collaborator {

        private final ProjectData.CollaboratorData collaboratorData;

        private Collaborator(ProjectData.CollaboratorData collaboratorData) {
            this.collaboratorData = collaboratorData;
        }

        public String getName() {
            return collaboratorData.name;
        }

        public String getEmail() {
            return collaboratorData.email;
        }

        @Override
        public String toString() {
            return "Collaborator{" +
                    "collaboratorData=" + collaboratorData +
                    '}';
        }
    }
}
