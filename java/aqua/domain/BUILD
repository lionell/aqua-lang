java_library(
    name = "tuple",
    srcs = ["Tuple.java"],
    visibility = ["//java/aqua:__subpackages__"],
    deps = [
        "//java/aqua/datatypes",
        "//third_party:guava",
    ],
)

java_library(
    name = "single_pass_algorithms",
    srcs = ["SinglePassAlgorithms.java"],
    deps = [
        ":data_stream",
        ":tuple",
        "//java/aqua/common",
        "//java/aqua/datatypes",
        "//java/aqua/expressions:condition",
        "//third_party:guava",
    ],
)

java_library(
    name = "data_stream",
    srcs = ["DataStream.java"],
    deps = [
        ":tuple",
        "//java/aqua/common",
        "//java/aqua/datatypes",
        "//java/aqua/expressions:condition",
        "//java/aqua/expressions:expression",
        "//third_party:guava",
    ],
)

java_library(
    name = "in_memory_table",
    srcs = ["InMemoryTable.java"],
    deps = [
        ":tuple",
    ],
)

java_library(
    name = "relation",
    srcs = ["Relation.java"],
    deps = [
        ":tuple",
    ],
)
