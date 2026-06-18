module "network" {
  source = "../../modules/network"

  environment = var.environment
  cidr_block  = "10.0.0.0/16"
}

module "kubernetes" {
  source = "../../modules/kubernetes"

  environment  = var.environment
  cluster_name = var.cluster_name
}

module "postgres" {
  source = "../../modules/postgres"

  database_name = var.postgres_db
}