# sscce-midje-lazy-throw

A SSCCE to investigate a midje test failure involving lazy seqs and exceptions.

Conclusions:

- midje appears to be inspecting the output of `update-atom` such that
  it walks the lazy seq and triggers the exception early.
- *Something* weird is happening to cause the seq to print as `()` and
  to swallow the exception in the second test.
- I should have had a doall in the `invert` fn if I wanted exceptions
  early anyhow!
