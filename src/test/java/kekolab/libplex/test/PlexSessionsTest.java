package kekolab.libplex.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import kekolab.javaplex.PlexMediatag;
import kekolab.javaplex.PlexTranscodeSession;

public class PlexSessionsTest extends PlexTests {

    @Test
    public void sessions() {
        List<PlexMediatag<?>> mediatags = getServer().status().sessions();
        assertNotNull(mediatags);

        // The following assertions need to have a session ongoing
        PlexMediatag<?> mediatag = mediatags.get(0);
        assertNotNull(mediatag.getSession());
        assertNotNull(mediatag.getSessionKey());
        assertNotNull(mediatag.getPlayer());

        // The following assertions need to have an active transcoding session
        PlexTranscodeSession transcodeSession = mediatags.stream().map(PlexMediatag::getTranscodeSession).findAny().get();
        assertNotNull(transcodeSession);
        assertNotNull(transcodeSession.getKey());
    }    
}
