package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import kekolab.javaplex.InviteRequest;
import kekolab.javaplex.InviteRequest.SharingSettings;
import kekolab.javaplex.PlexServer;
import kekolab.javaplex.PlexServers;
import kekolab.javaplex.PlexSharedServers;

public class PlexServersTests extends PlexTests {

    @Test
    public void test() throws URISyntaxException {
        PlexServers servers = new PlexServers(getClient(), getToken());
        assertNotNull(servers.getFriendlyName());
        assertNotNull(servers.getServers());
        assertNotEquals(0, servers.getServers().size());

		PlexServers.PlexServer server = servers.getServers().get(0);
        PlexSharedServers sharedServers = new PlexSharedServers(server, getClient(), getToken());
        assertNotNull(sharedServers.getMachineIdentifier());
        
        String email = "dummy@example.com";
        SharingSettings sharingSettings = new SharingSettings();
        sharingSettings.setAllowCameraUpload(true);
        sharingSettings.setAllowChannels(false);
        sharingSettings.setAllowSync(true);
        sharingSettings.setFilterMovies(new HashMap<String, List<String>>()); // TODO
        sharingSettings.setFilterMusic(new HashMap<String, List<String>>()); // TODO
        sharingSettings.setFilterTelevision(new HashMap<String, List<String>>()); // TODO
        InviteRequest.SharedServer ss = new InviteRequest.SharedServer();
        ss.setInvitedEmail(email);
        ss.setLibrarySectionIds(sharedServers.getSharedServers().get(0).getSections().stream().map(section -> section.getId()).toList());
        sharedServers.inviteFriend(email, sharedServers.getSharedServers().get(0).getSections(), sharingSettings);
    }
    
}
