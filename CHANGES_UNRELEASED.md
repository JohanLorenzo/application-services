**See [the release process docs](docs/howtos/cut-a-new-release.md) for the steps to take when cutting a new release.**

# Unreleased Changes

## Logins

### What's new

- Android: Added ability to rekey the database via `rekeyDatabase`. [[#2228](https://github.com/mozilla/application-services/pull/2228)]

[Full Changelog](https://github.com/mozilla/application-services/compare/v0.43.1...master)
## FxA Client

### What's new

* Android: BREAKING CHANGE: `migrateFromSessionToken` now reuses the existing 'sessionToken' instead of creating a new session token.
* Android: New method `copyFromSessionToken` will create a new 'sessionToken' state, this is what `migrateFromSessionToken` used to do,
before this release.


[Full Changelog](https://github.com/mozilla/application-services/compare/v0.44.0...master)
