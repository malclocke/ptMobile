package me.linnemann.ptmobile.pivotaltracker.xml;

import me.linnemann.ptmobile.pivotaltracker.Story;

public class UpdateStoryCommand extends StoryCommand {

	private static final String URL="http://www.pivotaltracker.com/services/v2/projects/PROJECT_ID/stories/STORY_ID";
	
	public UpdateStoryCommand(Story story) {
		super(story, URL);
	}
}
