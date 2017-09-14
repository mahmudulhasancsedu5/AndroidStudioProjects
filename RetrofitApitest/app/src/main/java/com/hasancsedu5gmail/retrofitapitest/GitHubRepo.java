package com.hasancsedu5gmail.retrofitapitest;

/**
 * Created by mahmud on 9/14/2017.
 */

public class GitHubRepo {
    private String name;
    private int id;
    private String full_name;

    public String getId() {
        return ""+id;
    }

    public String getFull_name() {
        return full_name;
    }


    public String getName(){

        return name;
    }
}

//{
//        "id": 99688707,
//        "name": "AJAX-JSON",
//        "full_name": "mahmudulhasancsedu5/AJAX-JSON",
//        "owner": {
//        "login": "mahmudulhasancsedu5",
//        "id": 15143436,
//        "avatar_url": "https://avatars1.githubusercontent.com/u/15143436?v=4",
//        "gravatar_id": "",
//        "url": "https://api.github.com/users/mahmudulhasancsedu5",
//        "html_url": "https://github.com/mahmudulhasancsedu5",
//        "followers_url": "https://api.github.com/users/mahmudulhasancsedu5/followers",
//        "following_url": "https://api.github.com/users/mahmudulhasancsedu5/following{/other_user}",
//        "gists_url": "https://api.github.com/users/mahmudulhasancsedu5/gists{/gist_id}",
//        "starred_url": "https://api.github.com/users/mahmudulhasancsedu5/starred{/owner}{/repo}",
//        "subscriptions_url": "https://api.github.com/users/mahmudulhasancsedu5/subscriptions",
//        "organizations_url": "https://api.github.com/users/mahmudulhasancsedu5/orgs",
//        "repos_url": "https://api.github.com/users/mahmudulhasancsedu5/repos",
//        "events_url": "https://api.github.com/users/mahmudulhasancsedu5/events{/privacy}",
//        "received_events_url": "https://api.github.com/users/mahmudulhasancsedu5/received_events",
//        "type": "User",
//        "site_admin": false
//        },
//        "private": false,
//        "html_url": "https://github.com/mahmudulhasancsedu5/AJAX-JSON",
//        "description": null,
//        "fork": false,
//        "url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON",
//        "forks_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/forks",
//        "keys_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/keys{/key_id}",
//        "collaborators_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/collaborators{/collaborator}",
//        "teams_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/teams",
//        "hooks_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/hooks",
//        "issue_events_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/issues/events{/number}",
//        "events_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/events",
//        "assignees_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/assignees{/user}",
//        "branches_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/branches{/branch}",
//        "tags_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/tags",
//        "blobs_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/git/blobs{/sha}",
//        "git_tags_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/git/tags{/sha}",
//        "git_refs_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/git/refs{/sha}",
//        "trees_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/git/trees{/sha}",
//        "statuses_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/statuses/{sha}",
//        "languages_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/languages",
//        "stargazers_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/stargazers",
//        "contributors_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/contributors",
//        "subscribers_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/subscribers",
//        "subscription_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/subscription",
//        "commits_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/commits{/sha}",
//        "git_commits_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/git/commits{/sha}",
//        "comments_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/comments{/number}",
//        "issue_comment_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/issues/comments{/number}",
//        "contents_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/contents/{+path}",
//        "compare_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/compare/{base}...{head}",
//        "merges_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/merges",
//        "archive_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/{archive_format}{/ref}",
//        "downloads_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/downloads",
//        "issues_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/issues{/number}",
//        "pulls_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/pulls{/number}",
//        "milestones_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/milestones{/number}",
//        "notifications_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/notifications{?since,all,participating}",
//        "labels_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/labels{/name}",
//        "releases_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/releases{/id}",
//        "deployments_url": "https://api.github.com/repos/mahmudulhasancsedu5/AJAX-JSON/deployments",
//        "created_at": "2017-08-08T12:10:41Z",
//        "updated_at": "2017-08-08T12:13:37Z",
//        "pushed_at": "2017-08-08T12:13:36Z",
//        "git_url": "git://github.com/mahmudulhasancsedu5/AJAX-JSON.git",
//        "ssh_url": "git@github.com:mahmudulhasancsedu5/AJAX-JSON.git",
//        "clone_url": "https://github.com/mahmudulhasancsedu5/AJAX-JSON.git",
//        "svn_url": "https://github.com/mahmudulhasancsedu5/AJAX-JSON",
//        "homepage": null,
//        "size": 1,
//        "stargazers_count": 0,
//        "watchers_count": 0,
//        "language": "JavaScript",
//        "has_issues": true,
//        "has_projects": true,
//        "has_downloads": true,
//        "has_wiki": true,
//        "has_pages": false,
//        "forks_count": 0,
//        "mirror_url": null,
//        "open_issues_count": 0,
//        "forks": 0,
//        "open_issues": 0,
//        "watchers": 0,
//        "default_branch": "master"
//        },
