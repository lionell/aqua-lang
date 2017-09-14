java_library(
    name = "in_memory_table",
    srcs = ["InMemoryTable.java"],
    deps = [
        ":relation",
        ":tuple",
        "//java/aqua/common",
        "//java/aqua/datatypes",
        "//java/aqua/expressions:expression",
        "//java/aqua/expressions:predicate",
        "//third_party:guava",
    ],
)

java_library(
    name = "tuple",
    srcs = ["Tuple.java"],
    visibility = ["//java/aqua:__subpackages__"],
    deps = [
        "//java/aqua/datatypes",
    ],
)

java_library(
    name = "relation",
    srcs = ["Relation.java"],
    visibility = ["//java/aqua:__subpackages__"],
    deps = [
        ":tuple",
        "//java/aqua/common",
        "//java/aqua/expressions:expression",
        "//java/aqua/expressions:predicate",
        "//third_party:guava",
    ],
)
