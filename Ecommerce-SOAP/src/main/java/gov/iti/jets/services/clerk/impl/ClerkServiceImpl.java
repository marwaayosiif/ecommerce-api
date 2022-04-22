package gov.iti.jets.services.clerk.impl;

import gov.iti.jets.persistence.entity.Clerk;
import gov.iti.jets.persistence.repository.clerk.ClerkRepository;
import gov.iti.jets.services.clerk.ClerkService;
import gov.iti.jets.services.clerk.dto.ClerkGetResponse;
import gov.iti.jets.services.clerk.dto.ClerkPostRequest;
import gov.iti.jets.services.clerk.dto.ClerkPutRequest;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "gov.iti.jets.services.clerk.ClerkService")
public class ClerkServiceImpl implements ClerkService {
    ClerkRepository clerkRepository = new ClerkRepository();
    @Override
    public List<ClerkGetResponse> getAllClerk() {
        List<Clerk> allClerks = clerkRepository.getAllClerks();
        List<ClerkGetResponse> clerks = new ArrayList<>();
        for ( Clerk clerk: allClerks ) {
            clerks.add( mapperFromClerkToClerkGetResponse( clerk ) );
        }
        return clerks;

    }

    @Override
    public ClerkGetResponse getClerkById( int id ) {
        Clerk clerk = clerkRepository.getClerk( id );
        return mapperFromClerkToClerkGetResponse( clerk );
    }

    @Override
    public String addClerk( ClerkPostRequest clerkPostRequest ) {
        return clerkRepository.addClerk( clerkPostRequest );
    }

    @Override
    public String deleteAllClerk() {
        return clerkRepository.deleteAllClerks();
    }

    @Override
    public String deleteClerkById( int id ) {
        return clerkRepository.deleteClerk( id );
    }

    @Override
    public ClerkGetResponse editClerk( int id, ClerkPutRequest clerkPutRequest ) {
        Clerk clerk = clerkRepository.editClerk( id, clerkPutRequest );
        return mapperFromClerkToClerkGetResponse( clerk );
    }

    private ClerkGetResponse mapperFromClerkToClerkGetResponse( Clerk clerk) {
        return new ClerkGetResponse( clerk.getId(), clerk.getName());
    }
}
