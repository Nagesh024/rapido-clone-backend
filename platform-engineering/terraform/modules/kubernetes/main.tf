resource "local_file" "cluster" {

  filename = "${path.module}/${var.cluster_name}.txt"

  content = <<EOF
Cluster=${var.cluster_name}
Environment=${var.environment}
EOF
}