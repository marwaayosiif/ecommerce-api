package gov.iti.jets.services.service.clerk;

import gov.iti.jets.persistence.entity.Clerk;
import gov.iti.jets.persistence.repository.clerk.ClerkRepository;
import gov.iti.jets.services.dto.clerk.ClerkGetResponse;
import gov.iti.jets.services.dto.clerk.ClerkPostRequest;
import gov.iti.jets.services.dto.clerk.ClerkPutRequest;

import java.util.ArrayList;
import java.util.List;

public class ClerkService {

    ClerkRepository clerkRepository = new ClerkRepository();

    public List<ClerkGetResponse> getAllClerks() {

        List<Clerk> allClerks = clerkRepository.getAllClerks();
        List<ClerkGetResponse> clerks = new ArrayList<>();
        for ( Clerk clerk: allClerks ) {
            clerks.add( mapperFromClerkToClerkGetResponse( clerk ) );
        }
        return clerks;
    }
    private ClerkGetResponse mapperFromClerkToClerkGetResponse( Clerk clerk) {
        return new ClerkGetResponse( clerk.getId(), clerk.getName());
    }

    public ClerkGetResponse getClerk( int id ) {
        Clerk clerk = clerkRepository.getClerk( id );
        return mapperFromClerkToClerkGetResponse( clerk );
    }

    public String addClerk( ClerkPostRequest clerkPostRequest ) {
        return clerkRepository.addClerk( clerkPostRequest );
    }

    public ClerkGetResponse editClerk( int id, ClerkPutRequest clerkPutRequest ) {
        Clerk clerk = clerkRepository.editClerk( id, clerkPutRequest );
        return mapperFromClerkToClerkGetResponse( clerk );
    }

    public String deleteAllClerks() {
        return clerkRepository.deleteAllClerks();
    }

    public String deleteClerk( int id ) {
        return clerkRepository.deleteClerk( id );
    }
}
